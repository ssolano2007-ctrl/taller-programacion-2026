package com.umb.taller.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.umb.taller.domain.model.Reserva;
import com.umb.taller.domain.repository.ReservaRepository;

public class ReservaRepositoryMemoria implements ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();

    @Override
    public Reserva guardar(Reserva reserva) {
        reservas.add(reserva);
        return reserva;
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return reservas.stream()
                .filter(reserva -> reserva.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Reserva> buscarTodos() {
        return new ArrayList<>(reservas);
    }

    @Override
    public void eliminarPorId(Long id) {
        reservas.removeIf(reserva -> reserva.getId().equals(id));
    }
}