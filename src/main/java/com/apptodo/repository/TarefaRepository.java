package com.apptodo.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apptodo.model.Categoria;
import com.apptodo.model.Tarefa;
import com.apptodo.model.Usuario;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    List<Tarefa> findByDataTarefaBetween(LocalDate dataInicial, LocalDate dataFinal);

    List<Tarefa> findByCategoria(Categoria categoria);

    List<Tarefa> findByUsuarios(List<Usuario> usuarios);

} 	