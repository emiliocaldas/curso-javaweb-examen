package com.mitocode.jwd.examen.specialty.application;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.jwd.examen.specialty.domain.Specialty;

@SpringBootTest
@Transactional
public class SpecialtyCreateServiceTest {

	private static final Logger log = LoggerFactory.getLogger(SpecialtyCreateServiceTest.class);

	@Autowired
	private SpecialtyCreateService specialtyCreateService;

	@Test
	@Commit
	public void createSpecialty() {
		Specialty specialty = new Specialty();
		specialty.setName("Pediatria");

		int rows = specialtyCreateService.save(specialty);

		assertNotEquals(0, rows);
		assertNotNull(specialty.getId());

		log.debug(specialty.toString());
	}

}
