package com.example.projetoTechAcademy.controller;


import com.example.projetoTechAcademy.dto.ItemPedidoDTO;
import com.example.projetoTechAcademy.dto.ItemRequestDTO;
import com.example.projetoTechAcademy.model.*;
import com.example.projetoTechAcademy.repository.CategoriaRepository;
import com.example.projetoTechAcademy.repository.ItemRepository;
import com.example.projetoTechAcademy.repository.PedidoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/Itens")
public class ItemController {

        @Autowired
        private ItemRepository repository;

        @Autowired
        private PedidoRepositoy pedidoRepositoy;

        @Autowired
        private CategoriaRepository categoriaRepository;

    @GetMapping
        public List<Item> findAll() {
            return  this.repository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Item> findById(@PathVariable Integer id){
            Item item = repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Item não foi encontrada"));
            return ResponseEntity.ok(item);
        }

        @PostMapping
        public ResponseEntity<Item> save(@RequestBody ItemRequestDTO dto) {
            Categoria categoria = categoriaRepository.findById(dto.idCategoria())
                    .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

            Item item = new Item();
            item.setNome(dto.nomeItem());
            item.setDescProduto(dto.descProduto());
            item.setPreco(dto.preco());
            item.setCategoria(categoria);
            item.setImagemUrl(dto.imagemUrl());
            item.setDescontoPercentual(dto.desconto_percentual());

            item = this.repository.save(item);

            return ResponseEntity.status(HttpStatus.CREATED).body(item);
        }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Item item = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cliente não foi encontrada"));

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
            item.setDescProduto(dto.descProduto());
            item.setPreco(dto.preco());
            item.setImagemUrl(dto.imagemUrl());

            this.repository.save(item);
            return ResponseEntity.ok(item);
        }

    @PostMapping("/{id}/add-pedido")
    public ResponseEntity<Item> addPedido(@PathVariable Integer id,
                                          @RequestBody ItemPedidoDTO dto) {


        Item item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));


        Pedido pedido = pedidoRepositoy.findById(dto.idPedido())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));


        ItemPedidoPK pk = new ItemPedidoPK();
        pk.setIdItem(item.getIdItem());
        pk.setIdPedido(pedido.getId());


        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(pk);
        itemPedido.setPedido(pedido);
        itemPedido.setItem(item);
        itemPedido.setQuantidade(dto.quantidade());
        itemPedido.setPrecoUnitario(dto.precoUnitario());


        item.addPedido(itemPedido);


        repository.save(item);


        return ResponseEntity.ok(item);
    }


    @PutMapping("/{id}/aplicar-desconto")
    public ResponseEntity<Item> aplicarDesconto(@PathVariable Integer id, @RequestParam BigDecimal percentualDesconto) {
        Item item = repository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado"));

        // Aplicando o desconto no item (isso recalcula o preço e atualiza o desconto)
        item.aplicarDesconto(percentualDesconto);

        // Salvando o item atualizado (com o preço recalculado)
        repository.save(item);

        return ResponseEntity.ok(item);
    }


}

