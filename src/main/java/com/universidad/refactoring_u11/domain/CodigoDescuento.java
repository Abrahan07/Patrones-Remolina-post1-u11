package com.universidad.refactoring_u11.domain;

public class CodigoDescuento {

    private final String codigo;
    private final double porcentaje;

    private CodigoDescuento(String codigo, double porcentaje) {
        this.codigo = codigo;
        this.porcentaje = porcentaje;
    }

    public static CodigoDescuento of(String codigo) {
        if (codigo == null || codigo.isBlank()) return null;
        return switch (codigo.toUpperCase()) {
            case "VIP10" -> new CodigoDescuento(codigo, 0.10);
            case "NEW20" -> new CodigoDescuento(codigo, 0.20);
            default -> throw new IllegalArgumentException("Codigo de descuento invalido: " + codigo);
        };
    }

    public String getCodigo() { return codigo; }
    public double getPorcentaje() { return porcentaje; }

    @Override
    public String toString() {
        return codigo + " (" + (porcentaje * 100) + "% descuento)";
    }
}