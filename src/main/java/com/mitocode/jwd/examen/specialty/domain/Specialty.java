package com.mitocode.jwd.examen.specialty.domain;

import java.util.List;

import com.mitocode.jwd.examen.doctor.domain.Doctor;

public class Specialty {

	private Integer id;
	private String name;
	private List<Doctor> doctors;

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

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Specialty [id=" + id + ", name=" + name + "]";
	}

}
