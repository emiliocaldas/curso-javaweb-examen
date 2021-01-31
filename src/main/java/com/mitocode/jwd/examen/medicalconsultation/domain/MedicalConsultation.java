package com.mitocode.jwd.examen.medicalconsultation.domain;

import java.time.LocalDate;
import java.util.List;

import com.mitocode.jwd.examen.doctor.domain.Doctor;
import com.mitocode.jwd.examen.patient.domain.Patient;

public class MedicalConsultation {

	private Integer id;
	private LocalDate createDate;
	private Doctor doctor;
	private Patient patient;
	private List<DetailConsultation> details;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<DetailConsultation> getDetails() {
		return details;
	}

	public void setDetails(List<DetailConsultation> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MedicalConsultation [id=" + id + ", createDate=" + createDate + ", doctor=" + doctor + ", patient="
				+ patient + ", details=" + details + "]";
	}

}
