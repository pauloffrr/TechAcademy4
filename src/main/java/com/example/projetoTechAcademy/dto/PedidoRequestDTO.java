package com.example.projetoTechAcademy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoRequestDTO(
        LocalDate data_pedido,
        String status_pedido,
        BigDecimal valor_total
) {
}
