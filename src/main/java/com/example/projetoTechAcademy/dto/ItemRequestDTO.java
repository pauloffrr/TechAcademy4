package com.example.projetoTechAcademy.dto;

import java.math.BigDecimal;

public record ItemRequestDTO (
    String nomeItem,
    String descProduto,
    BigDecimal preco,
    String imagemUrl

) {
}
