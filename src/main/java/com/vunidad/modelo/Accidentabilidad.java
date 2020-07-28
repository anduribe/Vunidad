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
@Table(name="Accidentabilidad")
public class Accidentabilidad {
	
	// nos guiaremos por el id como PK
	
		@Id

		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
		@SequenceGenerator(name="author_generator",initialValue = 1, allocationSize = 1, sequenceName = "ACCIDENTABILIDAD_SEQ")

		@Column(name = "id", updatable = false, nullable = false)
		private long id;
		@Column(name="Nombre_Empresa", length = 300)
		private String nombre;
		@Column(name="Promedio_de_trabajadores", length = 300)
		private String ntrabajadores;
		@Column(name="Cantidad_de_accidentes", length = 300)
		private String taccidentes;
		@Column(name="Tasa_de_Accidentabilidad", length = 300)
		private String tasa;
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
		public String getNtrabajadores() {
			return ntrabajadores;
		}
		public void setNtrabajadores(String ntrabajadores) {
			this.ntrabajadores = ntrabajadores;
		}
		public String getTaccidentes() {
			return taccidentes;
		}
		public void setTaccidentes(String taccidentes) {
			this.taccidentes = taccidentes;
		}
		public String getTasa() {
			return tasa;
		}
		public void setTasa(String tasa) {
			this.tasa = tasa;
		}
		
		
		@Override
		public String toString() {
			return "Accidentabilidad [id=" + id + ", nombre=" + nombre + ", ntrabajadores=" + ntrabajadores
					+ ", taccidentes=" + taccidentes + ", tasa=" + tasa + "]";
		}

		
		
		}
	
