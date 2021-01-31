package com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_consultation")
public class DetailConsultationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column
	private String diagnostic;

	@Column
	private String treatment;

	@ManyToOne
	@JoinColumn(name = "medical_consultation_id")
	private MedicalConsultationEntity medicalConsultation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public MedicalConsultationEntity getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultationEntity medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

	@Override
	public String toString() {
		return "DetailConsultationEntity [id=" + id + ", diagnostic=" + diagnostic + ", treatment=" + treatment + "]";
	}

}
