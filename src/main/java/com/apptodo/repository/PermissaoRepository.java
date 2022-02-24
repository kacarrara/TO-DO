package com.apptodo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apptodo.model.Permissao;

@Repository
public interface PermissaoRepository extends CrudRepository<Permissao, String>{

}
