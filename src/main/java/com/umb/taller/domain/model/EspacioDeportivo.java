package com.umb.taller.domain.model;

import com.umb.taller.domain.enums.EstadoEspacio;
import com.umb.taller.domain.enums.TipoEspacio;

public class EspacioDeportivo {

    private final Long id;
    private final String nombre;
    private final TipoEspacio tipo;
    private EstadoEspacio estado;
    private final int capacidadMaxima;

    public EspacioDeportivo(
            Long id,
            String nombre,
            TipoEspacio tipo,
            int capacidadMaxima) {

        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = EstadoEspacio.DISPONIBLE;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoEspacio getTipo() {
        return tipo;
    }

    public EstadoEspacio getEstado() {
        return estado;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean estaDisponible() {
        return estado == EstadoEspacio.DISPONIBLE;
    }

    public void ponerEnMantenimiento() {
        this.estado = EstadoEspacio.MANTENIMIENTO;
    }

    public void habilitar() {
        this.estado = EstadoEspacio.DISPONIBLE;
    }
}