package com.mitocode.jwd.examen.usuario.infrastructure.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mitocode.jwd.examen.usuario.domain.UsuarioEstadoEnum;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column
	private String usuario;

	@Column
	private String nombres;

	@Column
	private String claveUsuario;

	@Enumerated(EnumType.STRING)
	private UsuarioEstadoEnum estado;

	@Column
	private String rol;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public UsuarioEstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(UsuarioEstadoEnum estado) {
		this.estado = estado;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", usuario=" + usuario + ", nombres=" + nombres + ", claveUsuario="
				+ claveUsuario + ", estado=" + estado + ", rol=" + rol + "]";
	}

}
