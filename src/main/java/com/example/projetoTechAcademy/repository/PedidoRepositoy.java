package com.example.projetoTechAcademy.repository;

import com.example.projetoTechAcademy.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositoy extends JpaRepository <Pedido, Integer> {
}
