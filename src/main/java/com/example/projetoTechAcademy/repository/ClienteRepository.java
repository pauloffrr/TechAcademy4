package com.example.projetoTechAcademy.repository;

import com.example.projetoTechAcademy.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
