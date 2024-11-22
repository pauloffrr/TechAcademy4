package com.example.projetoTechAcademy.repository;

import com.example.projetoTechAcademy.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
