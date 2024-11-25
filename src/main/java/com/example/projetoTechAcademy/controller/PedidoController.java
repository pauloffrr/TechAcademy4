package com.example.projetoTechAcademy.controller;
import com.example.projetoTechAcademy.dto.PedidoRequestDTO;
import com.example.projetoTechAcademy.model.Pedido;
import com.example.projetoTechAcademy.repository.PedidoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

        @Autowired
        private PedidoRepositoy repository;

        @GetMapping
        public List<Pedido> findAll() {
            return  this.repository.findAll();
        }

        @GetMapping("/{id}")
        public Pedido findById(@PathVariable Integer id){
            return this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Pedido não foi encontrado"));
        }

        @PostMapping
        public Pedido save(@RequestBody PedidoRequestDTO dto) {

            Pedido pedido = new Pedido();
           pedido.setDataPedido(dto.data_pedido());
           pedido.setDataPedido(dto.data_pedido());
           pedido.setStatusPedido(dto.status_pedido());

            return this.repository.save(pedido);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            Pedido pedido = this.repository.findById(id)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Pedido não foi encontrado"));

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
                            new IllegalArgumentException("Status não foi encontrado"));

            pedido.setStatusPedido(dto.status_pedido());

            this.repository.save(pedido);
            return ResponseEntity.ok(pedido);
        }
}
