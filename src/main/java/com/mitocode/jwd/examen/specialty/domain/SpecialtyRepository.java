package com.mitocode.jwd.examen.specialty.domain;

import java.util.Optional;

public interface SpecialtyRepository {

	public int save(Specialty specialty);

	public Optional<Specialty> findbyId(Integer id);
}
