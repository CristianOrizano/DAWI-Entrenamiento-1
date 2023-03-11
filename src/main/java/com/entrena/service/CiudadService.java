package com.entrena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrena.entity.Administrador;
import com.entrena.entity.Ciudad;
import com.entrena.repository.CiudadRepository;

@Service
public class CiudadService {
	
	@Autowired
	private CiudadRepository repo;
	
	//listar
	public List<Ciudad> listCiuda(){
		return repo.findAll();
	}
	

}
