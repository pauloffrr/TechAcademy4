package com.example.projetoTechAcademy.dto;



public record ClienteRequestDTO(
        String nome,
        String email,
        String senha,
        String tel,
        String endereco
) {
}


