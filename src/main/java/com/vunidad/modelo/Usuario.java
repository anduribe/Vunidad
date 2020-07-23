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
@Table(name="Clientes")

public class Usuario {
	
	// nos guiaremos por el id como PK
	
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name="author_generator", sequenceName = "CLIENTES_SEQ")
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	@Column(name="Nombre", length = 300)
	private String nombre;
	@Column(name="Fecha", length = 300)
	private String fecha;
	@Column(name="RUT", length = 20)
	private String rut;
	@Column(name="Accidente", length = 200)
	private String accidente;
	
	
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getAccidente() {
		return accidente;
	}
	public void setAccidente(String accidente) {
		this.accidente = accidente;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", rut=" + rut + ", accidente="
				+ accidente + "]";
	}
	
	
	
	
	
	
	
	
	
	

	

}
