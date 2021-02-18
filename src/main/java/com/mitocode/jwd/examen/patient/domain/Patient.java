package com.mitocode.jwd.examen.patient.domain;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultation;

public class Patient {

	private Integer id;
	private String firstName;
	private String lastName;
	private String dni;
	private String numberClinicalHistory;
	private List<MedicalConsultation> medicalConsultations;

	public Patient() {
		medicalConsultations = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNumberClinicalHistory() {
		return numberClinicalHistory;
	}

	public void setNumberClinicalHistory(String numberClinicalHistory) {
		this.numberClinicalHistory = numberClinicalHistory;
	}

	public List<MedicalConsultation> getMedicalConsultations() {
		return medicalConsultations;
	}

	public void setMedicalConsultations(List<MedicalConsultation> medicalConsultations) {
		this.medicalConsultations = medicalConsultations;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni
				+ ", numberClinicalHistory=" + numberClinicalHistory + "]";
	}

}
