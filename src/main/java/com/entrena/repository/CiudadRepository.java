package com.entrena.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrena.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, String> {

}
