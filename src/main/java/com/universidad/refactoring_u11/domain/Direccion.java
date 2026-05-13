package com.universidad.refactoring_u11.domain;

public class Direccion {

    private final String calle;
    private final String ciudad;
    private final String codigoPostal;

    public Direccion(String calle, String ciudad, String codigoPostal) {
        if (calle == null || calle.isBlank())
            throw new IllegalArgumentException("La calle es requerida");
        if (ciudad == null || ciudad.isBlank())
            throw new IllegalArgumentException("La ciudad es requerida");
        if (codigoPostal == null || codigoPostal.isBlank())
            throw new IllegalArgumentException("El codigo postal es requerido");
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direccion)) return false;
        Direccion d = (Direccion) o;
        return calle.equals(d.calle) &&
                ciudad.equals(d.ciudad) &&
                codigoPostal.equals(d.codigoPostal);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(calle, ciudad, codigoPostal);
    }

    @Override
    public String toString() {
        return calle + ", " + ciudad + " " + codigoPostal;
    }
}