package com.dev.marcos.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Projeto responsável por manter o cadastro dos usuários e fornecer 
 * dados e funções relacionadas aos usuários
 */

@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

	// @Autowired
	// private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Gerador de senha no formato do brcrypt
		 */
		
//		System.out.println("BCrypt = " + passwordEncoder.encode("valor"));
	}

}
