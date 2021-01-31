package com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence;

import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultation;
import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultationRepository;
import com.mitocode.jwd.examen.medicalconsultation.infrastructure.dto.MedicalConsultationEntityMapper;
import com.mitocode.jwd.examen.shared.infrastructure.dto.CycleAvoidingMappingContext;

public class MedicalConsultationJpaRepository implements MedicalConsultationRepository {

	private MedicalConsultationCrudRepository medicalConsultationCrudRepository;
	private MedicalConsultationEntityMapper medicalConsultationEntityMapper;
	private CycleAvoidingMappingContext context;

	public MedicalConsultationJpaRepository(MedicalConsultationCrudRepository medicalConsultationCrudRepository,
			MedicalConsultationEntityMapper medicalConsultationEntityMapper) {
		this.medicalConsultationCrudRepository = medicalConsultationCrudRepository;
		this.medicalConsultationEntityMapper = medicalConsultationEntityMapper;
		this.context = new CycleAvoidingMappingContext();
	}

	@Override
	public int save(MedicalConsultation medicalConsultation) {
		MedicalConsultationEntity entity = medicalConsultationCrudRepository
				.save(medicalConsultationEntityMapper.toEntity(medicalConsultation, context));
		medicalConsultation.setId(entity.getId());

		return entity == null ? 0 : 1;
	}

}
