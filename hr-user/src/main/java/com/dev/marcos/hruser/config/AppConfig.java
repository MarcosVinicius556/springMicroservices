package com.dev.marcos.hruser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe de configuração da aplicação, 
 * que além das configurações também
 fornece os beans para a aplicação
 */

@Configuration
public class AppConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
