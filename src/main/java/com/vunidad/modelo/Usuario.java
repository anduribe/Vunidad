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

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_TRG")
	@SequenceGenerator(name="CLIENTES_TRG",initialValue = 1, allocationSize = 1, sequenceName = "CLIENTES_SEQ")
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
	@Column(name="Asesoria_Especial", length = 200)
	private String aespecial;
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
	public String getAespecial() {
		return aespecial;
	}
	public void setAespecial(String aespecial) {
		this.aespecial = aespecial;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", rut=" + rut + ", accidente="
				+ accidente + ", aespecial=" + aespecial + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	

}
