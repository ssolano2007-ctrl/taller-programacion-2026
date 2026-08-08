package com.umb.taller.domain.model;

public class Administrador extends Persona {

    private String codigoEmpleado;

    public Administrador(
            Long id,
            String nombre,
            String correo,
            String codigoEmpleado) {

        super(id, nombre, correo);
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    @Override
    public String obtenerRol() {
        return "ADMINISTRADOR";
    }
}
