package com.umb.taller.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.umb.taller.domain.model.Reserva;
import com.umb.taller.domain.repository.ReservaRepository;

public class ReservaService {

    private static final Logger logger =
            LoggerFactory.getLogger(ReservaService.class);

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva crearReserva(Reserva reserva) {

        logger.info("Iniciando proceso de creación de reserva.");

        Reserva reservaGuardada = reservaRepository.guardar(reserva);

        logger.info(
                "Reserva creada correctamente con id {}.",
                reservaGuardada.getId());

        return reservaGuardada;
    }
}