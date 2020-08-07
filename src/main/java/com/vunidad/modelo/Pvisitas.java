package com.vunidad.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



//creamos una entidad para hacer uso de jpa y crearemos directamente la tabla Asesorias

@Entity
@Table(name="Planificar_Visitas")
public class Pvisitas {
	
	// nos guiaremos por el id como PK
	
		@Id

		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
		@SequenceGenerator(name="author_generator",initialValue = 1, allocationSize = 1, sequenceName = "PLANIFICAR_VISITAS_SEQ")

		@Column(name = "id", updatable = false, nullable = false)
		private long id;
		@Column(name="Nombre_Cliente", length = 300)
		private String nombre;
		@Column(name="Email_Cliente", length = 300)
		private String email;
		@Column(name="Fecha_Visita", length = 300)
		private String fecha;
		@Column(name="Observaciones", length = 300)
		private String observaciones;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getObservaciones() {
			return observaciones;
		}
		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}
		@Override
		public String toString() {
			return "Pvisitas [id=" + id + ", nombre=" + nombre + ", email=" + email + ", fecha=" + fecha
					+ ", observaciones=" + observaciones + "]";
		}
		
		
		}
	
