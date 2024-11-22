package com.example.projetoTechAcademy.dto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
String nm_produto,
String desc_produto,
BigDecimal preco,
String imagem_url
) {
}
