package com.apptodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apptodo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	
	

}
