package com.example.projetoTechAcademy.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer idItem;

    @Column(name = "nome")
    private String nomeItem;

    @Column(name = "desc_produto")
    private String descProduto;

    @Column(name = "preco")
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> pedidos = new ArrayList<>();

    @Column(name = "desconto_percentual")
    private BigDecimal descontoPercentual = BigDecimal.ZERO;



    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nomeItem;
    }

    public void setNome(String nome) {
        this.nomeItem = nome;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public BigDecimal getDescontoPercentual() {
        return descontoPercentual;
    }

    public void setDescontoPercentual(BigDecimal descontoPercentual) {
        this.descontoPercentual = descontoPercentual;
    }

    public List<ItemPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItemPedido> pedidos) {
        this.pedidos = pedidos;
    }

    // Método para adicionar um pedido à lista
    public void addPedido(ItemPedido itemPedido) {
        if (this.pedidos == null) {
            this.pedidos = new ArrayList<>();
        }
        this.pedidos.add(itemPedido);
    }


    // Método para calcular o preço com desconto
    public BigDecimal calcularPrecoComDesconto() {
        if (descontoPercentual.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal desconto = preco.multiply(descontoPercentual).divide(BigDecimal.valueOf(100));
            return preco.subtract(desconto);
        }
        return preco;
    }

    // Método para aplicar um desconto ao item
    public void aplicarDesconto(BigDecimal percentual) {
        if (percentual.compareTo(BigDecimal.ZERO) >= 0 && percentual.compareTo(BigDecimal.valueOf(100)) <= 0) {
            this.descontoPercentual = percentual;
            BigDecimal desconto = this.preco.multiply(percentual).divide(BigDecimal.valueOf(100));
            this.preco = this.preco.subtract(desconto);  // Atualiza o preço com o desconto aplicado
        } else {
            throw new IllegalArgumentException("Desconto deve estar entre 0% e 100%");
        }
    }
}

