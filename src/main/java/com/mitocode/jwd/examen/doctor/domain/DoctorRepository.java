package com.mitocode.jwd.examen.doctor.domain;

import java.util.Optional;

import com.mitocode.jwd.examen.usuario.domain.Usuario;

public interface DoctorRepository {

	public Optional<Doctor> findByUsuario(Usuario usuario);
}
