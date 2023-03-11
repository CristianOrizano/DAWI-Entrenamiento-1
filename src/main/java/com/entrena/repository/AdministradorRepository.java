package com.entrena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.entrena.entity.Administrador;

import jakarta.transaction.Transactional;

public interface AdministradorRepository extends JpaRepository<Administrador,Integer>{
	
	@Transactional
	@Modifying
	@Query ("update Administrador a set a.estado.estado=?1 where a.codigoAd=?2")
	public void eliminarAdmi(int est,int codigo);
	
	@Query ("select a from Administrador a where a.estado.estado=?1")
	public List<Administrador> listadoActivo(int est);
	
	
	

}
