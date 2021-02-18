package com.mitocode.jwd.examen.medicalconsultation.application;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.jwd.examen.doctor.application.DoctorFinderService;
import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.doctor.domain.exception.DoctorNotFoundException;
import com.mitocode.jwd.examen.medicalconsultation.domain.DetailConsultation;
import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultation;
import com.mitocode.jwd.examen.patient.application.PatientFinderService;
import com.mitocode.jwd.examen.patient.domain.Patient;
import com.mitocode.jwd.examen.patient.domain.exception.PatientNotFoundException;

@SpringBootTest
@Transactional
public class MedicalConsultationCreateServiceTest {

	private static final Logger log = LoggerFactory.getLogger(MedicalConsultationCreateServiceTest.class);

	@Autowired
	private MedicalConsultationCreateService medicalConsultationCreateService;

	@Autowired
	private DoctorFinderService doctorFinderService;

	@Autowired
	private PatientFinderService patientFinderService;

	@Test
	@Commit
	public void createMedicalConsultation() {
		Optional<Doctor> doctor;
		try {
			doctor = doctorFinderService.findById(2); //1
		} catch (DoctorNotFoundException e) {
			doctor = Optional.empty();
		}
		if (!doctor.isPresent()) {
			log.warn("Ejecute primero la prueba del servicio Doctor...");
		}
		assertTrue(doctor.isPresent(), "Ejecute primero la prueba del servicio Doctor...");

		Optional<Patient> patient;
		try {
			patient = patientFinderService.findById(1);
		} catch (PatientNotFoundException e) {
			patient = Optional.empty();
		}
		if (!patient.isPresent()) {
			log.warn("Ejecute primero la prueba del servicio Patient...");
		}
		assertTrue(patient.isPresent(), "Ejecute primero la prueba del servicio Patient...");

		MedicalConsultation medicalConsultation = new MedicalConsultation();
		medicalConsultation.setCreateDate(LocalDate.now());
		medicalConsultation.setDoctor(doctor.get());
		medicalConsultation.setPatient(patient.get());

		List<DetailConsultation> details = new ArrayList<>();
		details.add(new DetailConsultation("Trigliceridos altos", "Dieta baja en grasas", medicalConsultation));
		details.add(new DetailConsultation("Grastritis leve", "Tomar medicacion", medicalConsultation));

		medicalConsultation.setDetails(details);

		int rows = medicalConsultationCreateService.save(medicalConsultation);

		assertNotEquals(0, rows);
		assertNotNull(medicalConsultation.getId());

		log.debug(medicalConsultation.toString());
	}

}
