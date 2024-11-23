package com.example.projetoTechAcademy.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ItemPedido")
public class ProdutoPedido {

    @EmbeddedId
    private ProdutoPedidoPK id;

    @ManyToOne
    @MapsId("idItem")
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @JsonIgnoreProperties("Pedido")
    private Item item;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    public ProdutoPedidoPK getId() {
        return id;
    }

    public void setId(ProdutoPedidoPK id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
