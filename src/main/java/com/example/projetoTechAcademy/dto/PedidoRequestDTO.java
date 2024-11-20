package com.example.projetoTechAcademy.dto;

import java.util.Date;

public record PedidoRequestDTO(
        Date data_pedido,
        String status_pedido,
        Integer valor_total
) {
}
