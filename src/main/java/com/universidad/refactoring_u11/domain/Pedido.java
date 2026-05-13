package com.universidad.refactoring_u11.domain;

import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;
    private String clienteNombre;
    private Double total;

    public Pedido() {}

    public Pedido(Long clienteId, String clienteNombre, Double total) {
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}