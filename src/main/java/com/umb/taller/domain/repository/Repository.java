package com.umb.taller.domain.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    T guardar(T entidad);

    Optional<T> buscarPorId(ID id);

    List<T> buscarTodos();

    void eliminarPorId(ID id);
}