package com.umb.taller.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {
    
    private final LocalDate fecha;
    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    public Horario(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
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

    public boolean esHorarioValido() {
        return horaFin.isAfter(horaInicio);
    }

    public boolean seCruzaCon(Horario otro) {
        if (!fecha.equals(otro.fecha)) {
            return false;
        }

        return horaInicio.isBefore(otro.horaFin) && horaFin.isAfter(otro.horaInicio);
    }




    
    
}
