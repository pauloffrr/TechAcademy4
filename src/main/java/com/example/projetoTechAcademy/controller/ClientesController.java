package com.example.projetoTechAcademy.controller;

import com.example.projetoTechAcademy.dto.ClientesRequestDTO;
import com.example.projetoTechAcademy.model.Clientes;
import com.example.projetoTechAcademy.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository repository;

    @GetMapping
    public List<Clientes> findAll() {
        return  this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Clientes findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cliente não foi encontrada"));
    }

    @PostMapping
    public Clientes save(@RequestBody ClientesRequestDTO dto) {


        Clientes clientes = new Clientes();
        clientes.setNome(dto.nome());



        return this.repository.save(clientes);
    }


}
