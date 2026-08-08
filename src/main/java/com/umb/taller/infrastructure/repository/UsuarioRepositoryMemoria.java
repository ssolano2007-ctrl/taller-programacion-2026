package com.umb.taller.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.umb.taller.domain.model.Usuario;
import com.umb.taller.domain.repository.UsuarioRepository;

public class UsuarioRepositoryMemoria implements UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario guardar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Usuario> buscarTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void eliminarPorId(Long id) {
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}