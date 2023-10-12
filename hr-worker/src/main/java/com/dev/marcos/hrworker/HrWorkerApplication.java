package com.dev.marcos.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Para este projeto poder ser um cliente do servidor de configuração
 * foi necessário adicionar 2 dependências
 * 
 * spring.cloud.config
 * spring.Cloud.Bootstrap
 */

@SpringBootApplication
public class HrWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

}
