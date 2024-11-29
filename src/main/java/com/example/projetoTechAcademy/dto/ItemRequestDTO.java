package com.example.projetoTechAcademy.dto;

import java.math.BigDecimal;

public record ItemRequestDTO (
    String nomeItem,
    String descProduto,
    BigDecimal preco,
    BigDecimal desconto_percentual,
    String imagemUrl

) {
}
