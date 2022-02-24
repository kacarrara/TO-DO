package com.apptodo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private static final long serialVersionUID = -886604392341594251L;
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @Id
	@Setter
	private String login;
    
    @Column
    private String nome;

    @Column
    private String email;
    
    @Column
    private String password;

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    private List<Tarefa> tarefas;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "REL_USUARIOS_ROLES", 
	joinColumns = { @JoinColumn(name = "LOGIN") },
	inverseJoinColumns = {@JoinColumn(name = "NOME_ROLE") }
	)
	@Getter
	@Setter
	private List<Role> roles;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "REL_USUARIO_PERMISSAO", joinColumns = { @JoinColumn(name = "LOGIN") }, inverseJoinColumns = {
			@JoinColumn(name = "NOME_PERMISSAO") })
	@Getter
	@Setter
	private List<Permissao> permissoes;

    
    
   
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		this.permissoes.stream().forEach(perm ->{
			GrantedAuthority authority =
					new SimpleGrantedAuthority(perm.getNomePermissao());
			authorities.add(authority);
		});
		
		this.roles.stream().forEach(role -> {
			GrantedAuthority authority=
					new SimpleGrantedAuthority(role.getNomeRole());
			authorities.add(authority);
		});
		
		return authorities;
	}

	
	public String getPassword() {
		return this.password;
	}

	
	public String getUsername() {
		return this.login;
	}

	
	public boolean isAccountNonExpired() {
		return true;
	}

	
	public boolean isAccountNonLocked() {
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		return true;
	}

	
	public boolean isEnabled() {
		return true;
	}
	


}
