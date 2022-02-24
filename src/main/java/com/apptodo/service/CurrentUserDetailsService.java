package com.apptodo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.apptodo.model.Usuario;
import com.apptodo.repository.UsuarioRepository;

@Component
@Transactional
public class CurrentUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(login);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		
		else {
			usuario.getAuthorities().size();
		}
			
			
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(),
				usuario.isAccountNonExpired(), usuario.isCredentialsNonExpired(), usuario.isAccountNonLocked(),
				usuario.getAuthorities());
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}