package com.apptodo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apptodo.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, String>{

}
