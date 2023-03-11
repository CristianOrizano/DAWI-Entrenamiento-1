package com.entrena.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estado")
public class Estado {
	@Id
	@Column(name="estado")
	private Integer estado;
	
	private String descripcion;
	
	@OneToMany(mappedBy = "estado")//ASOC nombre tipo
	private List<Administrador> listaAdmin;

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Administrador> getListaAdmin() {
		return listaAdmin;
	}

	public void setListaAdmin(List<Administrador> listaAdmin) {
		this.listaAdmin = listaAdmin;
	}
	
	
	

}
