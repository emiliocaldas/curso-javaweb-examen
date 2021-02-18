package com.mitocode.jwd.examen.usuario.infrastructure.dto;

import org.mapstruct.Mapper;

import com.mitocode.jwd.examen.usuario.domain.Usuario;
import com.mitocode.jwd.examen.usuario.infrastructure.persistence.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {

	Usuario toUsuario(UsuarioEntity entity);

	UsuarioEntity toEntity(Usuario usuario);
}
