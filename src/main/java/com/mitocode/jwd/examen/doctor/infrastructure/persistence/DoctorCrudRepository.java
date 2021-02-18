package com.mitocode.jwd.examen.doctor.infrastructure.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface DoctorCrudRepository extends PagingAndSortingRepository<DoctorEntity, Integer> {

}
