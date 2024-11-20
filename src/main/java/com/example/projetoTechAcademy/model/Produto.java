package com.example.projetoTechAcademy.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Produtos")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    @Column
    private String nm_produto;

    @Lob
    private String  desc_produto;

    @Column
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;

    @Column
    private String imagem_url;

}
