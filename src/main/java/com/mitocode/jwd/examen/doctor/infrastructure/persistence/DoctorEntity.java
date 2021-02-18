package com.mitocode.jwd.examen.doctor.infrastructure.persistence;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.mitocode.jwd.examen.medicalconsultation.infrastructure.persistence.MedicalConsultationEntity;
import com.mitocode.jwd.examen.specialty.infrastructure.persistence.SpecialtyEntity;
import com.mitocode.jwd.examen.usuario.infrastructure.persistence.UsuarioEntity;

@Entity
@Table(name = "doctor")
@DynamicUpdate
public class DoctorEntity {

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
	private String cmp;

	@ManyToOne
	@JoinColumn(name = "specialty_id")
	private SpecialtyEntity specialty;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
	private List<MedicalConsultationEntity> medicalConsultations;

	@OneToOne
	@JoinColumn(name = "usuario_id", unique = true)
	private UsuarioEntity usuario;

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

	public SpecialtyEntity getSpecialty() {
		return specialty;
	}

	public void setSpecialty(SpecialtyEntity specialty) {
		this.specialty = specialty;
	}

	public List<MedicalConsultationEntity> getMedicalConsultations() {
		return medicalConsultations;
	}

	public void setMedicalConsultations(List<MedicalConsultationEntity> medicalConsultations) {
		this.medicalConsultations = medicalConsultations;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DoctorEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dni=" + dni
				+ ", cmp=" + cmp + ", specialty=" + specialty + ", usuario=" + usuario + "]";
	}

}
