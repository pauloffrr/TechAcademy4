package com.example.projetoTechAcademy.repository;

import com.example.projetoTechAcademy.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
}
