package com.apptodo.service;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptodo.model.Usuario;
import com.apptodo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    static final ValidationException USUARIO_NAO_ENCONTRADO = new ValidationException("Usuário não encontrado");

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodosOsUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUmUsuario(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> USUARIO_NAO_ENCONTRADO);
    }

    public void delete(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> USUARIO_NAO_ENCONTRADO);
        usuarioRepository.delete(usuario);
    }
    
    public Usuario create(Usuario usuarioNovo) {
		usuarioNovo.setId(null);
		return usuarioRepository.save(usuarioNovo);
	}

}
