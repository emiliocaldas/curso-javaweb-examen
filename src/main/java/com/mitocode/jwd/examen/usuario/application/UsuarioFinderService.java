package com.mitocode.jwd.examen.usuario.application;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.usuario.domain.Usuario;
import com.mitocode.jwd.examen.usuario.domain.UsuarioRepository;
import com.mitocode.jwd.examen.usuario.domain.exception.UsuarioNotFoundException;

@Service
public class UsuarioFinderService {

	private UsuarioRepository usuarioRepository;

	public UsuarioFinderService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario findByUsuario(String usuario) throws UsuarioNotFoundException {
		return usuarioRepository.findByUsuario(usuario).orElseThrow(UsuarioNotFoundException::new);
	}

}
