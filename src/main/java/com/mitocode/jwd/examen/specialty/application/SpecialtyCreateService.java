package com.mitocode.jwd.examen.specialty.application;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.specialty.domain.Specialty;
import com.mitocode.jwd.examen.specialty.domain.SpecialtyRepository;

@Service
public class SpecialtyCreateService {

	private SpecialtyRepository specialtyRepository;

	public SpecialtyCreateService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}
	
	public int save(Specialty specialty) {
		int rows = specialtyRepository.save(specialty);
		
		return rows;
	}
	
}
