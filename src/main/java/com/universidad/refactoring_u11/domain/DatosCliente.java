package com.universidad.refactoring_u11.domain;

public class DatosCliente {

    private final String nombre;
    private final String email;
    private final String telefono;
    private final Direccion direccion;

    public DatosCliente(String nombre, String email,
                        String telefono, Direccion direccion) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre es requerido");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("El email es invalido");
        if (direccion == null)
            throw new IllegalArgumentException("La direccion es requerida");
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public Direccion getDireccion() { return direccion; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DatosCliente)) return false;
        DatosCliente d = (DatosCliente) o;
        return nombre.equals(d.nombre) &&
                email.equals(d.email);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(nombre, email);
    }

    @Override
    public String toString() {
        return nombre + " <" + email + ">";
    }
}