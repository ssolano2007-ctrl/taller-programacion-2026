package com.umb.taller.application.service;

import java.time.LocalDate;

import com.umb.taller.domain.model.EspacioDeportivo;
import com.umb.taller.domain.model.Horario;
import com.umb.taller.domain.model.Usuario;
import com.umb.taller.domain.validation.Validador;

public class ValidacionService {

    private final Validador<Usuario> validadorUsuarioActivo =
            usuario -> usuario != null && usuario.isActivo();

    private final Validador<EspacioDeportivo> validadorEspacioDisponible =
            espacio -> espacio != null && espacio.estaDisponible();

    private final Validador<Horario> validadorFechaReserva =
            horario -> horario != null &&
                    !horario.getFecha().isBefore(LocalDate.now());

    private final Validador<EspacioDeportivo> validadorDisponibilidadReferencia =
            EspacioDeportivo::estaDisponible;

    public boolean validarUsuarioActivo(Usuario usuario) {
        return validadorUsuarioActivo.validar(usuario);
    }

    public boolean validarEspacioDisponible(EspacioDeportivo espacio) {
        return validadorEspacioDisponible.validar(espacio);
    }

    public boolean validarFechaReserva(Horario horario) {
        return validadorFechaReserva.validar(horario);
    }

    public boolean validarDisponibilidadConReferencia(EspacioDeportivo espacio) {
        return espacio != null &&
                validadorDisponibilidadReferencia.validar(espacio);
    }
}