package com.mitocode.jwd.examen.doctor.application;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.specialty.application.SpecialtyFinderService;
import com.mitocode.jwd.examen.specialty.domain.Specialty;
import com.mitocode.jwd.examen.specialty.domain.exception.SpecialtyNotFoundException;
import com.mitocode.jwd.examen.usuario.domain.Usuario;

@SpringBootTest
@Transactional
public class DoctorCreateServiceTest {

	private static final Logger log = LoggerFactory.getLogger(DoctorCreateServiceTest.class);

	@Autowired
	private DoctorCreateService doctorCreateService;

	@Autowired
	private SpecialtyFinderService specialtyFinderService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Test
	@Commit
	public void createDoctor() {
		// Crear usuario para el Medico
		Usuario usuario = new Usuario();
		usuario.setUsuario("luis.flores");
		usuario.setNombres("Luis Flores");
		usuario.setClaveUsuario(passwordEncoder.encode("123456"));
		usuario.setRol("DOCTOR");

		// Crear Medico
		Optional<Specialty> specialty;
		try {
			specialty = specialtyFinderService.findById(1);
		} catch (SpecialtyNotFoundException e) {
			specialty = Optional.empty();
		}
		if (!specialty.isPresent()) {
			log.warn("Ejecute primero la prueba del Servicio Specialty...");
		}
		assertTrue(specialty.isPresent(), "Ejecute primero la prueba del Servicio Specialty...");

		Doctor doctor = new Doctor();
		doctor.setFirstName("Luis");
		doctor.setLastName("Flores");
		doctor.setDni("99999910");
		doctor.setCmp("7777-7777");
		doctor.setUsuario(usuario);
		doctor.setSpecialty(specialty.get());

		int rows = doctorCreateService.save(doctor);

		assertNotEquals(0, rows);
		assertNotNull(doctor.getId());

		log.debug(doctor.toString());
	}

}
