package com.umb.taller.domain.model;

public class Usuario extends Persona {

    private final String codigoInstitucional;
    private boolean activo;

    public Usuario(
            Long id,
            String nombre,
            String correo,
            String codigoInstitucional) {

        super(id, nombre, correo);

        this.codigoInstitucional = codigoInstitucional;
        this.activo = true;
    }

    public String getCodigoInstitucional() {
        return codigoInstitucional;
    }

    public boolean isActivo() {
        return activo;
    }

    public void activar() {
        this.activo = true;
    }

    public void desactivar() {
        this.activo = false;
    }

    @Override
    public String obtenerRol() {
        return "USUARIO";
    }
}