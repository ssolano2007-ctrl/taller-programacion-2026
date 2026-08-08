package com.umb.taller.domain.model;

public abstract class Persona {

    private final Long id;
    private final String nombre;
    private final String correo;

    public Persona(Long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public abstract String obtenerRol();
}
