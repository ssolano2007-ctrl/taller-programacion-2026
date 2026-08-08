package com.umb.taller.application.service;

import com.umb.taller.domain.model.Usuario;
import com.umb.taller.domain.repository.UsuarioRepository;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }
}