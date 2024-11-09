package com.example.projetoTechAcademy.dto;



public record ClientesRequestDTO(
        String nome,
        String email,
        String senha,
        String tel,
        String endereco
) {
}


