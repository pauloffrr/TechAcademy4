package com.example.projetoTechAcademy.dto;

import java.math.BigDecimal;

public record ItemRequestDTO (
    String nomeItem,
    String descProduto,
    BigDecimal preco,
    Integer idCategoria,
    String imagemUrl,
    BigDecimal desconto_percentual

) {
}
