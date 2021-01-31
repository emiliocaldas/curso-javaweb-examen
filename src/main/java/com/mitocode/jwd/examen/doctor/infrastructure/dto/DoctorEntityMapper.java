package com.mitocode.jwd.examen.doctor.infrastructure.dto;

import org.mapstruct.Mapper;

import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.doctor.infrastructure.persistence.DoctorEntity;
import com.mitocode.jwd.examen.specialty.infrastructure.dto.SpecialtyEntityMapper;

@Mapper(componentModel = "spring", uses = { SpecialtyEntityMapper.class })
public interface DoctorEntityMapper {

	Doctor toDoctor(DoctorEntity entity);

	DoctorEntity toEntity(Doctor doctor);
}
