package com.vunidad.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



//creamos una entidad para hacer uso de jpa y crearemos directamente la tabla Mejoras

@Entity
@Table(name="Mejoras")
public class Mejoras {
	
	// nos guiaremos por el id como PK
	
		@Id

		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
		@SequenceGenerator(name="author_generator",initialValue = 1, allocationSize = 1, sequenceName = "MEJORAS_SEQ")
		
		@Column(name = "id", updatable = false, nullable = false)
		private long id;
		@Column(name="Nombre", length = 300)
		private String nombre;
		@Column(name="Actividad_Mejora", length = 300)
		private String amejora;
		@Column(name="Fecha", length = 300)
		private String fecha;
		@Column(name="Crear_Capacitacion", length = 300)
		private String ccapacitacion;
		@Column(name="Detalle_Capacitacion", length = 300)
		private String dcapacitacion;
		
		//crear Getter and Setters
		
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
		public String getAmejora() {
			return amejora;
		}
		public void setAmejora(String amejora) {
			this.amejora = amejora;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getCcapacitacion() {
			return ccapacitacion;
		}
		public void setCcapacitacion(String ccapacitacion) {
			this.ccapacitacion = ccapacitacion;
		}
		public String getDcapacitacion() {
			return dcapacitacion;
		}
		public void setDcapacitacion(String dcapacitacion) {
			this.dcapacitacion = dcapacitacion;
		}
		
		
		// Crear toString
		
		@Override
		public String toString() {
			return "Mejoras [id=" + id + ", nombre=" + nombre + ", amejora=" + amejora + ", fecha=" + fecha
					+ ", ccapacitacion=" + ccapacitacion + ", dcapacitacion=" + dcapacitacion + "]";
		}
	
	
	
	
	
	

}
