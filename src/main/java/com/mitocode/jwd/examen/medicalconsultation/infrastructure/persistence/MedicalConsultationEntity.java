package com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mitocode.jwd.examen.doctor.infrastructure.persistence.DoctorEntity;
import com.mitocode.jwd.examen.patient.infrastructure.persistence.PatientEntity;

@Entity
@Table(name = "medical_consultation")
public class MedicalConsultationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column
	private LocalDate createDate;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private DoctorEntity doctor;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	@OneToMany(mappedBy = "medicalConsultation", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DetailConsultationEntity> details;

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

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public List<DetailConsultationEntity> getDetails() {
		return details;
	}

	public void setDetails(List<DetailConsultationEntity> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MedicalConsultationEntity [id=" + id + ", createDate=" + createDate + ", doctor=" + doctor
				+ ", patient=" + patient + ", details=" + details + "]";
	}

}
