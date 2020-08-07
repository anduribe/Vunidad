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
@Table(name="Control_Pago_Clientes")

public class CPclientes {
	
	// nos guiaremos por el id como PK
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name="author_generator",initialValue = 1, allocationSize = 1, sequenceName = "CONTROL_PAGO_CLIENTES_SEQ")
	
	
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name="Factura", length = 300)
	private String factura;
	
	@Column(name="RUT_EMPRESA", length = 20)
	private String rut;
	
	@Column(name="Nombre_Empresa", length = 300)
	private String nombre;

	
	@Column(name="Telefono_Empresa", length = 300)
	private String telefono;
	
	@Column(name="Email_de_contacto", length = 200)
	private String email;
	
	@Column(name="Estado_de_pago", length = 200)
	private String epago;
	
	@Column(name="Fecha_de_pago", length = 200)
	private String fecha;
	
	@Column(name="Monto_deuda", length = 200)
	private String mdeuda;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getEpago() {
		return epago;
	}

	public void setEpago(String epago) {
		this.epago = epago;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMdeuda() {
		return mdeuda;
	}

	public void setMdeuda(String mdeuda) {
		this.mdeuda = mdeuda;
	}

	
	@Override
	public String toString() {
		return "CPclientes [id=" + id + ", factura=" + factura + ", rut=" + rut + ", nombre=" + nombre + ", telefono="
				+ telefono + ", email=" + email + ", epago=" + epago + ", fecha=" + fecha + ", mdeuda=" + mdeuda + "]";
	}

	

}
