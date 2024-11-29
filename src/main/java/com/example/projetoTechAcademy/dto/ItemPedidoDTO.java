package com.example.projetoTechAcademy.dto;

import java.math.BigDecimal;

public record ItemPedidoDTO(
        Integer idPedido,
        Integer idItem,
        int quantidade,
        BigDecimal precoUnitario
) {}
