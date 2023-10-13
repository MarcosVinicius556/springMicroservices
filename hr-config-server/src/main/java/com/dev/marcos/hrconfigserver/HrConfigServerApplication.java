package com.dev.marcos.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Este será um serviço onde será centralizado 
 * as configurações dos microsserviços da aplicação
 * 
 * Estas configurações (no caso deste projeto em específico)
 * encontram-se no github
 *
 * Antes de um microsserviço subir no eureka-server, se ele estiver configurado
 * como um cliente de um servidor de confIGURAÇÃO, ele irá buscar
 * as configurações antes de subir 
 */

@EnableConfigServer //Habilitando este projeto como um servidor de configuração
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	@Value("${spring.cloud.config.server.git.username}")
	private String githubUser;

	@Value("${spring.cloud.config.server.git.password}")
	private String githubPass;

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Usuário do GIT Configurado: " + githubUser);
		System.out.println("Senha do GIT Configurada: " + githubPass);
	}

}
