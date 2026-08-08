package com.umb.taller.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.umb.taller.domain.exception.ValidationException;

class HorarioTest {

    @Test
    void deberiaCrearHorarioValido() {

        Horario horario = new Horario(
                LocalDate.of(2026, 8, 15),
                LocalTime.of(14, 0),
                LocalTime.of(16, 0));

        assertThat(horario.getFecha())
                .isEqualTo(LocalDate.of(2026, 8, 15));

        assertThat(horario.getHoraInicio())
                .isEqualTo(LocalTime.of(14, 0));

        assertThat(horario.getHoraFin())
                .isEqualTo(LocalTime.of(16, 0));
    }

    @Test
    void deberiaDetectarCruceDeHorarios() {

        Horario horario1 = new Horario(
                LocalDate.of(2026, 8, 15),
                LocalTime.of(14, 0),
                LocalTime.of(16, 0));

        Horario horario2 = new Horario(
                LocalDate.of(2026, 8, 15),
                LocalTime.of(15, 0),
                LocalTime.of(17, 0));

        assertThat(horario1.seCruzaCon(horario2))
                .isTrue();
    }

    @Test
    void noDeberiaDetectarCruceEnFechasDiferentes() {

        Horario horario1 = new Horario(
                LocalDate.of(2026, 8, 15),
                LocalTime.of(14, 0),
                LocalTime.of(16, 0));

        Horario horario2 = new Horario(
                LocalDate.of(2026, 8, 16),
                LocalTime.of(14, 0),
                LocalTime.of(16, 0));

        assertThat(horario1.seCruzaCon(horario2))
                .isFalse();
    }

    @Test
    void deberiaLanzarExcepcionCuandoHoraFinEsAnterior() {

        assertThatThrownBy(() ->
                new Horario(
                        LocalDate.of(2026, 8, 15),
                        LocalTime.of(16, 0),
                        LocalTime.of(14, 0)))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(
                        "La hora de finalización debe ser posterior");
    }

    @Test
    void deberiaLanzarExcepcionCuandoLosDatosSonNulos() {

        assertThatThrownBy(() ->
                new Horario(
                        null,
                        LocalTime.of(14, 0),
                        LocalTime.of(16, 0)))
                .isInstanceOf(ValidationException.class)
                .hasMessageContaining(
                        "La fecha y las horas del horario son obligatorias");
    }
}
