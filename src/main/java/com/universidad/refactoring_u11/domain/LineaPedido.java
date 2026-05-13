package com.universidad.refactoring_u11.domain;

public class LineaPedido {

    private final Long productoId;
    private final int cantidad;
    private final double precioUnitario;

    public LineaPedido(Long productoId, int cantidad, double precioUnitario) {
        if (cantidad <= 0)
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        if (precioUnitario <= 0)
            throw new IllegalArgumentException("El precio debe ser mayor a cero");
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Long getProductoId() { return productoId; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
}