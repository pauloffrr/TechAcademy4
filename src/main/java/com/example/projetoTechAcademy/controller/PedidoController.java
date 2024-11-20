package com.example.projetoTechAcademy.controller;

import com.example.projetoTechAcademy.dto.PedidoRequestDTO;
import com.example.projetoTechAcademy.model.Pedido;
import com.example.projetoTechAcademy.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidos = this.repository.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não foi encontrada"));
    }

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody PedidoRequestDTO dto) {
        if (dto.status_pedido().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Pedido pedido = new Pedido();
        pedido.setStatus_pedido(dto.status_pedido());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não foi encontrada"));

        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        if (dto.status_pedido().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não foi encontrada"));

        pedido.setStatus_pedido(dto.status_pedido());

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}
