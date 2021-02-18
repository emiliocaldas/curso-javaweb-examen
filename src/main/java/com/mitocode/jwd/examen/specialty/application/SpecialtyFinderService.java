package com.mitocode.jwd.examen.specialty.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.jwd.examen.specialty.domain.Specialty;
import com.mitocode.jwd.examen.specialty.domain.SpecialtyRepository;
import com.mitocode.jwd.examen.specialty.domain.exception.SpecialtyNotFoundException;

@Service
public class SpecialtyFinderService {

	private SpecialtyRepository specialtyRepository;

	public SpecialtyFinderService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	public Optional<Specialty> findById(Integer id) throws SpecialtyNotFoundException {
		return Optional.ofNullable(specialtyRepository.findbyId(id).orElseThrow(SpecialtyNotFoundException::new));
	}

}
