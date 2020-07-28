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
@Table(name="Checklist")
public class Checklist {
	
	// nos guiaremos por el id como PK
	
		@Id

		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
		@SequenceGenerator(name="author_generator",initialValue = 1, allocationSize = 1, sequenceName = "CHECKLIST_SEQ")

		@Column(name = "id", updatable = false, nullable = false)
		private long id;
		@Column(name="Nombre_Profesional", length = 300)
		private String nombre;
		@Column(name="Fecha_Checklist", length = 300)
		private String fecha;
		@Column(name="Check_Administrativo", length = 300)
		private String chadministrativo;
		@Column(name="Check_Operativo", length = 300)
		private String chterreno;
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
		public String getChadministrativo() {
			return chadministrativo;
		}
		public void setChadministrativo(String chadministrativo) {
			this.chadministrativo = chadministrativo;
		}
		public String getChterreno() {
			return chterreno;
		}
		public void setChterreno(String chterreno) {
			this.chterreno = chterreno;
		}
		@Override
		public String toString() {
			return "Checklist [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", chadministrativo="
					+ chadministrativo + ", chterreno=" + chterreno + "]";
		}
		
		
		
		
		
		
		
		}
	
