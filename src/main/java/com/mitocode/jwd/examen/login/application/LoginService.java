package com.mitocode.jwd.examen.login.application;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.login.domain.exception.BadCredentialsException;
import com.mitocode.jwd.examen.login.domain.exception.UserBlockedException;
import com.mitocode.jwd.examen.usuario.domain.Usuario;
import com.mitocode.jwd.examen.usuario.domain.UsuarioEstadoEnum;
import com.mitocode.jwd.examen.usuario.domain.UsuarioRepository;

@Service
public class LoginService {

	private UsuarioRepository usuarioRepository;

	public LoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario validateUserAndPassword(String user, String password)
			throws BadCredentialsException, UserBlockedException {
		boolean resultado = usuarioRepository.login(user, password);

		if (!resultado) {
			throw new BadCredentialsException();
		} else {
			Usuario usuario = usuarioRepository.findByUsuario(user).get();

			if (usuario.getEstado().equals(UsuarioEstadoEnum.BLOQUEADO)) {
				throw new UserBlockedException();
			} else {
				return usuario;
			}
		}
	}

}
