
package com.example.projetoTechAcademy.repository;

import com.example.projetoTechAcademy.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Optional<Pedido> findById(Integer id);
}



