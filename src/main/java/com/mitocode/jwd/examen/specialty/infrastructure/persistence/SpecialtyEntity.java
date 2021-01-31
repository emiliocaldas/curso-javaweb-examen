package com.mitocode.jwd.examen.specialty.infrastructure.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mitocode.jwd.examen.doctor.infrastructure.persistence.DoctorEntity;

@Entity
@Table(name = "specialty")
public class SpecialtyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column
	private String name;

	@OneToMany(mappedBy = "specialty", cascade = CascadeType.REMOVE)
	private List<DoctorEntity> doctors;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DoctorEntity> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<DoctorEntity> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "SpecialtyEntity [id=" + id + ", name=" + name + "]";
	}

}
