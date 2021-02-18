package com.mitocode.jwd.examen.patient.application;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.jwd.examen.patient.domain.Patient;

@SpringBootTest
@Transactional
public class PatientCreateServiceTest {

	private static final Logger log = LoggerFactory.getLogger(PatientCreateServiceTest.class);

	@Autowired
	private PatientCreateService patientCreateService;

	@Test
	@Commit
	public void createPatient() {
		Patient patient = new Patient();
		patient.setFirstName("Raul");
		patient.setLastName("Ramirez");
		patient.setDni("88888801");
		patient.setNumberClinicalHistory("555-5555");

		int rows = patientCreateService.save(patient);

		assertNotEquals(0, rows);
		assertNotNull(patient.getId());

		log.debug(patient.toString());
	}

}
