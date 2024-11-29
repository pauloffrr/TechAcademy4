package com.example.projetoTechAcademy.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id;

    @ManyToOne
    @MapsId("idItem")
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    @JsonIgnoreProperties("Pedido")
    private Item item;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
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
