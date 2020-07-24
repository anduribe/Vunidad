package com.vunidad.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// creamos una entidad para hacer uso de jpa y crearemos directamente la tabla Clientes

@Entity
@Table(name="Profesionales")

public class Profesionales {
	
	// nos guiaremos por el id como PK
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name="author_generator",initialValue = 1, allocationSize = 1, sequenceName = "PROFESIONALES_SEQ1")

	
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name="Nombre", length = 300)
	private String nombre;

	@Column(name="RUT", length = 20)
	private String rut;
	
	@Column(name="Telefono", length = 300)
	private String telefono;
	
	@Column(name="Email", length = 200)
	private String email;
	
	@Column(name="Actividad", length = 200)
	private String actividad;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	
	@Override
	public String toString() {
		return "Profesionales [id=" + id + ", nombre=" + nombre + ", rut=" + rut + ", telefono=" + telefono + ", email="
				+ email + ", actividad=" + actividad + "]";
	}

	

}
