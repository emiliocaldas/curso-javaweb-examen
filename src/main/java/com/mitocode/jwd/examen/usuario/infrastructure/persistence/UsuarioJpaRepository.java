package com.mitocode.jwd.examen.usuario.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.jwd.examen.usuario.domain.Usuario;
import com.mitocode.jwd.examen.usuario.domain.UsuarioRepository;
import com.mitocode.jwd.examen.usuario.infrastructure.dto.UsuarioEntityMapper;

@Repository
public class UsuarioJpaRepository implements UsuarioRepository {

	private UsuarioCrudRepository usuarioCrudRepository;
	private UsuarioEntityMapper usuarioEntityMapper;

	public UsuarioJpaRepository(UsuarioCrudRepository usuarioCrudRepository, UsuarioEntityMapper usuarioEntityMapper) {
		this.usuarioCrudRepository = usuarioCrudRepository;
		this.usuarioEntityMapper = usuarioEntityMapper;
	}

	@Override
	public int save(Usuario usuario) {
		UsuarioEntity entity = usuarioCrudRepository.save(usuarioEntityMapper.toEntity(usuario));
		usuario.setId(entity.getId());

		return entity == null ? 0 : 1;
	}

	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		return usuarioCrudRepository.findByUsuario(usuario).map(usuarioEntityMapper::toUsuario);
	}

	@Override
	public boolean login(String user, String password) {
		Optional<UsuarioEntity> entity = usuarioCrudRepository.findByUsuarioAndClaveUsuario(user, password);

		return entity.isPresent();
	}

}
