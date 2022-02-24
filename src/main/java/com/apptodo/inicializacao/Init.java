package com.apptodo.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.apptodo.model.Permissao;
import com.apptodo.model.Role;
import com.apptodo.model.Usuario;
import com.apptodo.service.CurrentUserDetailsService;
import com.apptodo.service.PermissaoService;
import com.apptodo.service.RoleService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private PermissaoService permissaoService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private CurrentUserDetailsService usuarioService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Usuario usuario = new Usuario();
		usuario.setNome("Karina Carrara");
		usuario.setLogin("admin");
		usuario.setPassword(new BCryptPasswordEncoder().encode("1234"));

		Role roleAdmin = new Role();
		roleAdmin.setNomeRole(Role.ROLE_ADMIN);
		roleService.salvar(roleAdmin);

		usuario.setRoles(Arrays.asList(roleAdmin));
		usuarioService.salvar(usuario);

		// ##############################################

		Usuario usuario2 = new Usuario();
		usuario2.setNome("Adriana Silva");
		usuario2.setLogin("adriana");
		usuario2.setPassword(new BCryptPasswordEncoder().encode("1234"));

		Role roleUser = new Role();
		roleUser.setNomeRole(Role.ROLE_USER);
		roleService.salvar(roleUser);

		usuario2.setRoles(Arrays.asList(roleUser));

		Permissao permissaoUser = new Permissao();
		permissaoUser.setNomePermissao(Permissao.INSERT);
		permissaoService.salvar(permissaoUser);

		usuario2.setPermissoes(Arrays.asList(permissaoUser));

		usuarioService.salvar(usuario2);

		// ##############################################

		Usuario usuario3 = new Usuario();
		usuario3.setNome("Fabricio Mesquita");
		usuario3.setLogin("fabricio");
		usuario3.setPassword(new BCryptPasswordEncoder().encode("10a11b12c"));

		roleService.salvar(roleUser);
		usuario3.setRoles(Arrays.asList(roleUser));
		usuarioService.salvar(usuario3);
	}

}