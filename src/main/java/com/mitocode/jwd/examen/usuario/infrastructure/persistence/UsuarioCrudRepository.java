package com.mitocode.jwd.examen.usuario.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioCrudRepository extends PagingAndSortingRepository<UsuarioEntity, Integer> {

	Optional<UsuarioEntity> findByUsuario(String usuario);

	Optional<UsuarioEntity> findByUsuarioAndClaveUsuario(String usuario, String claveUsuario);

}
