package com.umb.taller.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.umb.taller.domain.enums.EstadoReserva;
import com.umb.taller.domain.enums.TipoEspacio;
import com.umb.taller.domain.exception.BusinessRuleException;
import com.umb.taller.domain.exception.ValidationException;

class ReservaTest {

    private Usuario usuario;
    private EspacioDeportivo espacio;
    private Horario horario;
    private Reserva reserva;

    @BeforeEach
    void configurar() {

        usuario = new Usuario(
                1L,
                "Andres Solano",
                "andres@umb.edu.co",
                "U001");

        espacio = new EspacioDeportivo(
                1L,
                "Cancha principal",
                TipoEspacio.FUTBOL,
                22);

        horario = new Horario(
                LocalDate.of(2026, 8, 20),
                LocalTime.of(14, 0),
                LocalTime.of(16, 0));

        reserva = new Reserva(
                1L,
                usuario,
                espacio,
                horario);
    }

    @Test
    void deberiaCrearReservaComoPendiente() {

        assertThat(reserva.getEstado())
                .isEqualTo(EstadoReserva.PENDIENTE);
    }

    @Test
    void deberiaConfirmarReservaPendiente() {

        reserva.confirmar();

        assertThat(reserva.getEstado())
                .isEqualTo(EstadoReserva.CONFIRMADA);
    }

    @Test
    void deberiaFinalizarReservaConfirmada() {

        reserva.confirmar();
        reserva.finalizar();

        assertThat(reserva.getEstado())
                .isEqualTo(EstadoReserva.FINALIZADA);
    }

    @Test
    void noDeberiaConfirmarReservaCancelada() {

        reserva.cancelar();

        assertThatThrownBy(reserva::confirmar)
                .isInstanceOf(BusinessRuleException.class)
                .hasMessageContaining(
                        "Solo una reserva pendiente puede ser confirmada");
    }

    @Test
    void noDeberiaFinalizarReservaPendiente() {

        assertThatThrownBy(reserva::finalizar)
                .isInstanceOf(BusinessRuleException.class)
                .hasMessageContaining(
                        "Solo una reserva confirmada puede ser finalizada");
    }

    @Test
    void noDeberiaCrearReservaConIdInvalido() {

        assertThatThrownBy(() ->
                new Reserva(
                        0L,
                        usuario,
                        espacio,
                        horario))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(
                        "El identificador de la reserva debe ser válido");
    }

    @Test
    void noDeberiaCrearReservaSinUsuario() {

        assertThatThrownBy(() ->
                new Reserva(
                        2L,
                        null,
                        espacio,
                        horario))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(
                        "El usuario de la reserva es obligatorio");
    }

    @Test
    void noDeberiaCrearReservaSinEspacioDeportivo() {

        assertThatThrownBy(() ->
                new Reserva(
                        3L,
                        usuario,
                        null,
                        horario))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(
                        "El espacio deportivo de la reserva es obligatorio");
    }

    @Test
    void noDeberiaCrearReservaSinHorario() {

        assertThatThrownBy(() ->
                new Reserva(
                        4L,
                        usuario,
                        espacio,
                        null))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(
                        "El horario de la reserva es obligatorio");
    }
}