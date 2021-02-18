package com.mitocode.jwd.examen.doctor.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.doctor.domain.DoctorRepository;
import com.mitocode.jwd.examen.usuario.domain.UsuarioRepository;

@Service
public class DoctorCreateService {

	private DoctorRepository doctorRepository;
	private UsuarioRepository usuarioRepository;

	public DoctorCreateService(DoctorRepository doctorRepository, UsuarioRepository usuarioRepository) {
		this.doctorRepository = doctorRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public int save(Doctor doctor) {
		int rows = usuarioRepository.save(doctor.getUsuario());

		if (rows > 0) {
			rows = doctorRepository.save(doctor);
		}

		return rows;
	}
}
