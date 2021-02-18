package com.mitocode.jwd.examen.specialty.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;
import com.mitocode.jwd.examen.specialty.domain.Specialty;
import com.mitocode.jwd.examen.specialty.domain.SpecialtyRepository;
import com.mitocode.jwd.examen.specialty.infrastructure.dto.SpecialtyEntityMapper;

@Repository
public class SpecialtyJpaRepository implements SpecialtyRepository {

	private SpecialtyCrudRepository specialtyCrudRepository;
	private SpecialtyEntityMapper specialtyEntityMapper;
	private CycleAvoidingMappingContext context;

	public SpecialtyJpaRepository(SpecialtyCrudRepository specialtyCrudRepository,
			SpecialtyEntityMapper specialtyEntityMapper) {
		this.specialtyCrudRepository = specialtyCrudRepository;
		this.specialtyEntityMapper = specialtyEntityMapper;
	}

	@Override
	public int save(Specialty specialty) {
		context = new CycleAvoidingMappingContext();
		SpecialtyEntity entity = specialtyCrudRepository.save(specialtyEntityMapper.toEntity(specialty, context));
		specialty.setId(entity.getId());

		return entity == null ? 0 : 1;
	}

	@Override
	public Optional<Specialty> findbyId(Integer id) {
		context = new CycleAvoidingMappingContext();
		return specialtyCrudRepository.findById(id).map(entity -> specialtyEntityMapper.toSpecialty(entity, context));
	}

}
