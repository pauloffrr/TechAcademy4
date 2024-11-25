package com.example.projetoTechAcademy.model;

import jakarta.persistence.Column;


import java.util.Objects;

public class ProdutoPedidoPK {

    @Column(name = "id_pedido")
    private Integer idPedido;

    @Column(name = "id_item" )
    private Integer idItem;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoPedidoPK that = (ProdutoPedidoPK) o;
        return Objects.equals(idPedido, that.idPedido) && Objects.equals(idItem, that.idItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, idItem);
    }
}
