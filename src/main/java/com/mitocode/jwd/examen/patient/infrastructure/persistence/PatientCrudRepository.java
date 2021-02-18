package com.mitocode.jwd.examen.patient.infrastructure.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientCrudRepository extends PagingAndSortingRepository<PatientEntity, Integer> {

}
