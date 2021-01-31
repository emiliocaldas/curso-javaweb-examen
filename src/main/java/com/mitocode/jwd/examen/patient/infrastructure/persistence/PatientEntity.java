package com.mitocode.jwd.examen.patient.infrastructure.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence.MedicalConsultationEntity;

@Entity
@Table(name = "patient")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String dni;

	@Column
	private String numberClinicalHistory;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE)
	private List<MedicalConsultationEntity> medicalConsultations;

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

	public List<MedicalConsultationEntity> getMedicalConsultations() {
		return medicalConsultations;
	}

	public void setMedicalConsultations(List<MedicalConsultationEntity> medicalConsultations) {
		this.medicalConsultations = medicalConsultations;
	}

	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni
				+ ", numberClinicalHistory=" + numberClinicalHistory + "]";
	}

}
