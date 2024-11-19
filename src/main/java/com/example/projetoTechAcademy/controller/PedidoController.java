package com.example.projetoTechAcademy.controller;

import com.example.projetoTechAcademy.dto.ClienteRequestDTO;
import com.example.projetoTechAcademy.dto.PedidoRequestDTO;
import com.example.projetoTechAcademy.model.Cliente;
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
    public List<Cliente> findAll() {
        return  this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Pedido não foi encontrada"));
    }

    @PostMapping
    public Pedido save(@RequestBody PedidoRequestDTO dto) {

        Pedido pedido = new Pedido();
        pedido.setNome(dto.nome());
        pedido.setEmail(dto.email());
        pedido.setSenha(dto.senha());
        pedido.setTel(dto.tel());
        pedido.setEndereco(dto.endereco());

        return this.repository.save(clientes);
    }

}
