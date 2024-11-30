package com.example.projetoTechAcademy.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Pedido")
public class Pedido extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private LocalDate dataPedido;

    @Column(name = "status_pedido")
    private String statusPedido;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean validate() {
        return false;
    }
}
