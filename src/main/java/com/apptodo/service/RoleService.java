package com.apptodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptodo.model.Role;
import com.apptodo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role salvar (Role role) {
		return roleRepository.save(role);
	}
}
