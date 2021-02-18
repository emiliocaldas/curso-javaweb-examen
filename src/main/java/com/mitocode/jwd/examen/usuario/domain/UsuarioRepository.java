package com.mitocode.jwd.examen.usuario.domain;

import java.util.Optional;

public interface UsuarioRepository {

	public int save(Usuario usuario);

	public Optional<Usuario> findByUsuario(String usuario);

	public boolean login(String user, String password);

}
