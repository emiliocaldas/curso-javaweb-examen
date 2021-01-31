package com.mitocode.jwd.examen.doctor.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.doctor.domain.DoctorRepository;
import com.mitocode.jwd.examen.doctor.domain.exception.DoctorNotFoundException;
import com.mitocode.jwd.examen.usuario.domain.Usuario;

@Service
public class DoctorFinderService {

	private DoctorRepository doctorRepository;

	public DoctorFinderService(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	public Optional<Doctor> findByUsuario(Usuario usuario) throws DoctorNotFoundException {
		return Optional.ofNullable(doctorRepository.findByUsuario(usuario).orElseThrow(DoctorNotFoundException::new));
	}
}
