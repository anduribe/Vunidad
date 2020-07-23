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
@Table(name="Asesorias")
public class Asesorias {
	
	// nos guiaremos por el id como PK
	
		@Id

		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
		@SequenceGenerator(name="author_generator", sequenceName = "ASESORIAS_SEQ")
		@Column(name = "id", updatable = false, nullable = false)
		private long id;
		@Column(name="Nombre", length = 300)
		private String nombre;
		@Column(name="Fecha", length = 300)
		private String fecha;
		@Column(name="Tipo_de_Asesoria", length = 300)
		private String tasesoria;
		@Column(name="Asesoria_especial", length = 300)
		private String aespecial;
		@Column(name="Detalle_Asesoria", length = 300)
		private String dasesoria;
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
		public String getTasesoria() {
			return tasesoria;
		}
		public void setTasesoria(String tasesoria) {
			this.tasesoria = tasesoria;
		}
		public String getAespecial() {
			return aespecial;
		}
		public void setAespecial(String aespecial) {
			this.aespecial = aespecial;
		}
		public String getDasesoria() {
			return dasesoria;
		}
		public void setDasesoria(String dasesoria) {
			this.dasesoria = dasesoria;
		}
		
		
		@Override
		public String toString() {
			return "Asesorias [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", tasesoria=" + tasesoria
					+ ", aespecial=" + aespecial + ", dasesoria=" + dasesoria + "]";
		}	
		
		
		
		}
	
