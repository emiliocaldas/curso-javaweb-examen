package com.mitocode.jwd.examen.doctor.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.doctor.domain.DoctorRepository;
import com.mitocode.jwd.examen.doctor.infrastructure.dto.DoctorEntityMapper;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;
import com.mitocode.jwd.examen.usuario.domain.Usuario;

@Repository
public class DoctorJpaRepository implements DoctorRepository {

	private DoctorCrudRepository doctorCrudRepository;
	private DoctorEntityMapper doctorEntityMapper;
	private CycleAvoidingMappingContext context;

	public DoctorJpaRepository(DoctorCrudRepository doctorCrudRepository, DoctorEntityMapper doctorEntityMapper) {
		this.doctorCrudRepository = doctorCrudRepository;
		this.doctorEntityMapper = doctorEntityMapper;
	}

	@Override
	public int save(Doctor doctor) {
		context = new CycleAvoidingMappingContext();
		DoctorEntity entity = doctorCrudRepository.save(doctorEntityMapper.toEntity(doctor, context));
		doctor.setId(entity.getId());

		return entity == null ? 0 : 1;
	}

	@Override
	public Optional<Doctor> findByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Doctor> findById(Integer id) {
		context = new CycleAvoidingMappingContext();
		return doctorCrudRepository.findById(id).map(entity -> doctorEntityMapper.toDoctor(entity, context));
	}

}
