package com.example.projetoTechAcademy.controller;

import com.example.projetoTechAcademy.dto.ClienteRequestDTO;
import com.example.projetoTechAcademy.model.Cliente;
import com.example.projetoTechAcademy.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> findAll() {
        return  this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cliente não foi encontrada"));
    }

    @PostMapping
    public Cliente save(@RequestBody ClienteRequestDTO dto) {

        Cliente clientes = new Cliente();
        clientes.setNome(dto.nome());
        clientes.setEmail(dto.email());
        clientes.setSenha(dto.senha());
        clientes.setTel(dto.tel());
        clientes.setEndereco(dto.endereco());

        return this.repository.save(clientes);
    }


}
