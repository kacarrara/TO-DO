package com.apptodo.security;

import java.io.IOException;
import java.util.Date;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apptodo.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			Usuario user = new ObjectMapper().readValue(request.getInputStream(), 
					com.apptodo.domain.Usuario.class);
			return this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							user.getUsername(), user.getPassword()));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String userName = ((Usuario) authResult.getPrincipal()).getUsername();
		String token = Jwts.builder().setSubject(userName)
				.setExpiration(new Date(System.currentTimeMillis() 
						+ ESecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256,
						ESecurityConstants.SECRET.desc())
				.compact();
		response.addHeader(ESecurityConstants.HEADER.desc(), 
				ESecurityConstants.TOKEN_PREFIX.desc() + token);

	}
}