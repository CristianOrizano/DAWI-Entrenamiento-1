package com.entrena.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_Administrador")
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_adm")
	private int codigoAd;
	//no es necesario poner colum si es igual aal BD
	@Column(name="nombre")
	private String nombre;
	
	private String apellido;

	private String Direccion;
	
	private int telefono;
	
	private double sueldo;
	
	private String sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac")
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechanaci;
	
	@ManyToOne
	@JoinColumn(name="cod_ciu")
	private Ciudad ciudad;
	
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estado;
	

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getCodigoAd() {
		return codigoAd;
	}

	public void setCodigoAd(Integer codigoAd) {
		this.codigoAd = codigoAd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechanaci() {
		return fechanaci;
	}

	public void setFechanaci(Date fechanaci) {
		this.fechanaci = fechanaci;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
