package com.example.projetoTechAcademy.controller;

import com.example.projetoTechAcademy.dto.CategoriaRequestDTO;
import com.example.projetoTechAcademy.model.Categoria;
import com.example.projetoTechAcademy.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = this.repository.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody CategoriaRequestDTO dto) {
        if (dto.nome_categoria().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Categoria categoria = new Categoria();
        categoria.setNome_categoria(dto.nome_categoria());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        this.repository.delete(categoria);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody CategoriaRequestDTO dto) {
        if (dto.nome_categoria().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Categoria categoria = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        categoria.setNome_categoria(dto.nome_categoria());

        this.repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

}
