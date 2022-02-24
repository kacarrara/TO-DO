package com.apptodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptodo.model.Permissao;
import com.apptodo.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public Permissao salvar (Permissao permissao) {
		return permissaoRepository.save(permissao);
	}
}
