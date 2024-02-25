package com.dev.marcos.hroauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configurações gerais da aplicação
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private FilterToken filterToken;
	
	/**
	 * bean que irá criptografar e decriptografar as senhas
	 */
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
     * @apiNote Quando o "AutenticationManager" for chamado na classe service de autenticação, ele irá buscar aqui o objeto
     * @param authenticationConfiguration
     * @return
     * @throws Exception
     */
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
					//Desabilitando o cors temporariamente....
		return http.cors(cors -> cors.disable())
					//Desabilitando o csrf temporariamente....
				   .csrf(csrf -> csrf.disable())
				   //Definindo a aplicação com STATELESS, ou seja, não guarda estado
				   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				   //Configuração das rotas, quais deverão ser livres, quais serão autenticadas
				   .authorizeHttpRequests(request ->  {
					request.requestMatchers(HttpMethod.POST, "/login").permitAll();
					request.requestMatchers(HttpMethod.GET, "/users/*").permitAll();
					request.anyRequest().authenticated();
				   })
				   //Filtro que irá pegar nosssa requisição e verificar se está autenticada
				   .addFilterBefore(filterToken, UsernamePasswordAuthenticationFilter.class) 
				   //Criando o filtro que irá tratar as requisições
				   .build();
	}

	
}
