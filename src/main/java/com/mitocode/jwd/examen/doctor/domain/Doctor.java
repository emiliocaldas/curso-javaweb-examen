package com.mitocode.jwd.examen.doctor.domain;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.jwd.examen.medicalconsultation.domain.MedicalConsultation;
import com.mitocode.jwd.examen.specialty.domain.Specialty;
import com.mitocode.jwd.examen.usuario.domain.Usuario;

public class Doctor {

	private Integer id;
	private String firstName;
	private String lastName;
	private String dni;
	private String cmp;
	private Specialty specialty;
	private List<MedicalConsultation> medicalConsultations;
	private Usuario usuario;

	public Doctor() {
		specialty = new Specialty();
		medicalConsultations = new ArrayList<>();
		usuario = new Usuario();
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

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public List<MedicalConsultation> getMedicalConsultations() {
		return medicalConsultations;
	}

	public void setMedicalConsultations(List<MedicalConsultation> medicalConsultations) {
		this.medicalConsultations = medicalConsultations;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni + ", cmp="
				+ cmp + ", specialty=" + specialty + ", medicalConsultations=" + medicalConsultations + ", usuario="
				+ usuario + "]";
	}

}
