package com.umb.taller.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.umb.taller.domain.exception.ValidationException;

public class Horario {

    private final LocalDate fecha;
    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    public Horario(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {

        if (fecha == null || horaInicio == null || horaFin == null) {
            throw new ValidationException(
                    "La fecha y las horas del horario son obligatorias.");
        }

        if (!horaFin.isAfter(horaInicio)) {
            throw new ValidationException(
                    "La hora de finalización debe ser posterior a la hora de inicio.");
        }

        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public boolean seCruzaCon(Horario otro) {

        if (otro == null) {
            return false;
        }

        if (!fecha.equals(otro.fecha)) {
            return false;
        }

        return horaInicio.isBefore(otro.horaFin)
                && horaFin.isAfter(otro.horaInicio);
    }
}