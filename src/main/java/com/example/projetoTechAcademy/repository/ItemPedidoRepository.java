package com.example.projetoTechAcademy.repository;


import com.example.projetoTechAcademy.model.ItemPedido;
import com.example.projetoTechAcademy.model.ItemPedidoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {

}
