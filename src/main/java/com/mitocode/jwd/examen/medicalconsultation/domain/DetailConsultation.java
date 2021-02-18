package com.mitocode.jwd.examen.medicalconsultation.domain;

public class DetailConsultation {

	private Integer id;
	private String diagnostic;
	private String treatment;
	private MedicalConsultation medicalConsultation;

	public DetailConsultation() {
		medicalConsultation = new MedicalConsultation();
	}

	public DetailConsultation(String diagnostic, String treatment, MedicalConsultation medicalConsultation) {
		this.diagnostic = diagnostic;
		this.treatment = treatment;
		this.medicalConsultation = medicalConsultation;
	}

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

	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

	@Override
	public String toString() {
		return "DetailConsultation [id=" + id + ", diagnostic=" + diagnostic + ", treatment=" + treatment + "]";
	}

}
