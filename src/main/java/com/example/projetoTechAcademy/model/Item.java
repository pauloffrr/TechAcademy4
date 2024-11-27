package com.example.projetoTechAcademy.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private List<ProdutoPedido> pedidos = new ArrayList<>();

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

    public void setPedidos(List<ProdutoPedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedido(ProdutoPedido produtoPedido) {
        if (this.pedidos == null) {
            this.pedidos = new ArrayList<>();
        }
        this.pedidos.add(produtoPedido);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(idItem, item.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idItem);
    }

}
