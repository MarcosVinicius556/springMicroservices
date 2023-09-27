package com.devsuperior.hreurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Tornando este nosso projeto apto para ser um servidor eureka
 * 
 * Este projeto tem por objetivo encapsular os microsserviços, fazendo com que 
 * possamos chamar um microsserviço apenas pelo nome, sem ter que nos preocupar-mos 
 * com o endereço, porta ou qualquer coisa deste genêro, ele irá "englobar" nossa aplicação
 * para tornar mais fácil o acesso a cada microsserviço
 */
@EnableEurekaServer
@SpringBootApplication
public class HrEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEurekaServerApplication.class, args);
	}

}
