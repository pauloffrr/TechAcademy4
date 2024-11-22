package com.example.projetoTechAcademy.controller;


import com.example.projetoTechAcademy.dto.ItemRequestDTO;
import com.example.projetoTechAcademy.model.Item;
import com.example.projetoTechAcademy.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Itens")
public class ItemController {

        @Autowired
        private ItemRepository repository;

        @GetMapping
        public List<Item> findAll() {
            return  this.repository.findAll();
        }

        @GetMapping("/{id}")
        public Item findById(@PathVariable Integer id){
            return this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Item não foi encontrada"));
        }

        @PostMapping
        public Item save(@RequestBody ItemRequestDTO dto) {

            Item item = new Item();
            item.setNome(dto.nomeItem());
            item.setDescProduto(dto.descProduto());
            item.setPreco(dto.preco());
            item.setImagemUrl(dto.imagemUrl());

            return this.repository.save(item);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            Item item = this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Item não foi encontrada"));

            this.repository.delete(item);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody ItemRequestDTO dto) {
            if (dto.nomeItem().isEmpty()) {
                return ResponseEntity.status(428).build();
            }

            Item item = this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Item não foi encontrada"));

            item.setNome(dto.nomeItem());

            this.repository.save(item);
            return ResponseEntity.ok(item);
        }

    }
