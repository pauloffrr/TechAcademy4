package com.example.projetoTechAcademy.repository;

import com.example.projetoTechAcademy.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
