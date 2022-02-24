package com.apptodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apptodo.model.Categoria;
import com.apptodo.service.CategoriaService;

@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/todas")
    public List<Categoria> findAll() {
        return categoriaService.buscarTodasAsCategorias();
    }

    @GetMapping("/buscar/{id}")
    public Categoria findCategoria(@PathVariable int id) {
        return categoriaService.buscarUmaCategoria(id);
    }

    @PostMapping("/salvar")
    public void salvarCategoria(@RequestBody Categoria categoria) {
        categoriaService.save(categoria);
    }

    @GetMapping("/delete/{id}")
    public void deleteCategoria(@PathVariable int id) {
        categoriaService.delete(id);
    }

}
