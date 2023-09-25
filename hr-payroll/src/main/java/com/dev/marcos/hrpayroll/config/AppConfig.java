package com.dev.marcos.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configurações da nossa aplicação, 
 * também utilizada para disponibilizar objetos e variáveis para o nosso sistema
 */
@Configuration
public class AppConfig {

	/**
	 * Criando um "bean" que ficará responsável por retornar um RestTemplate
	 * Disponibiliza este componente de forma estática para toda a aplicação utilizar
	 * podendo assim ser chamado através de método e poder utilizar a injeção de dependências
	 */
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();	
	}
}
