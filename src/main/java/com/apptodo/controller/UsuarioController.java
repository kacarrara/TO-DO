package com.apptodo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apptodo.model.Usuario;
import com.apptodo.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/todos")
    public List<Usuario> findAll() {
        return usuarioService.buscarTodosOsUsuarios();
    }

    @GetMapping("/buscar/{id}")
    public Usuario findUsuario(@PathVariable int id) {
        return usuarioService.buscarUmUsuario(id);
    }

    @PostMapping("/salvar")
    public void salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @GetMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable int id) {
        usuarioService.delete(id);
    }
    
    @PostMapping
	public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuarioNovo) {
		Usuario usuario = usuarioService.create(usuarioNovo);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{usuarioId}")
				.buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
