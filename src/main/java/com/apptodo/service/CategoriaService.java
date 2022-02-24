package com.apptodo.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptodo.model.Categoria;
import com.apptodo.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    static final ValidationException CATEGORIA_NAO_ENCONTRADA = new ValidationException("Categoria não encontrada");

    public void save(Categoria Categoria) {
        categoriaRepository.save(Categoria);
    }

    public List<Categoria> buscarTodasAsCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarUmaCategoria(int id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> CATEGORIA_NAO_ENCONTRADA);
    }

    public void delete(int id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> CATEGORIA_NAO_ENCONTRADA);
        categoriaRepository.delete(categoria);
    }
}
