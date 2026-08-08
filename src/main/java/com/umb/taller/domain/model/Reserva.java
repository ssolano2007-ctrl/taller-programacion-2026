package com.umb.taller.domain.model;

import java.time.LocalDateTime;

import com.umb.taller.domain.enums.EstadoReserva;

import com.umb.taller.domain.exception.BusinessRuleException;

public class Reserva {

    private final Long id;
    private final Usuario usuario;
    private final EspacioDeportivo espacio;
    private final Horario horario;
    private EstadoReserva estado;
    private final LocalDateTime fechaCreacion;

    public Reserva(
        Long id,
        Usuario usuario,
        EspacioDeportivo espacio,
        Horario horario) {
        
        this.id = id;
        this.usuario = usuario;
        this.espacio = espacio;
        this.horario = horario;
        this.estado = EstadoReserva.PENDIENTE;
        this.fechaCreacion = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public EspacioDeportivo getEspacio() {
        return espacio;
    }

    public Horario getHorario() {
        return horario;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void confirmar() {
        if (estado != EstadoReserva.PENDIENTE) {
            throw new BusinessRuleException(
                "Solo una reserva pendiente puede ser confirmada.");
        }
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        if (estado == EstadoReserva.CANCELADA ||
            estado == EstadoReserva.FINALIZADA) {

            throw new BusinessRuleException(
                "La reserva no puede ser cancelada en su estado actual.");
        }
        this.estado = EstadoReserva.CANCELADA;
    }

    public void finalizar() {
        if (estado != EstadoReserva.CONFIRMADA) {
            throw new BusinessRuleException(
                "Solo una reserva confirmada puede ser finalizada.");
        }
        this.estado = EstadoReserva.FINALIZADA; 
    }


}

