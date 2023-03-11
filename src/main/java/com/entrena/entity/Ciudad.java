package com.entrena.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Ciudad")
public class Ciudad {
	
	@Id
	@Column(name="cod_ciu")
	private String codigoCiu;
	//no es necesario poner colum si es igual aal BD
	@Column(name="nom_ciu")
	private String nombre;
	
	@OneToMany(mappedBy = "ciudad")//ASOC nombre tipo
	private List<Administrador> listaAdmin;
	
	

	public String getCodigoCiu() {
		return codigoCiu;
	}

	public void setCodigoCiu(String codigoCiu) {
		this.codigoCiu = codigoCiu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Administrador> getListaAdmin() {
		return listaAdmin;
	}

	public void setListaAdmin(List<Administrador> listaAdmin) {
		this.listaAdmin = listaAdmin;
	}
	
	

}
