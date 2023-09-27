package com.dev.marcos.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Para que possa ser utilizado o feign no projeto,
 * e que o mesmo tenha uma instancia disponível para
 * a aplicação, é necessário utilizar esta anotação
 */
@EnableFeignClients
/**
 * Ribbon é uma das formas de trabalhar com balanceamento de cargas 
 * com spring cloud, ele irá verificar no momento em  que for realizada uma requisição
 * qual a instancia do microsserviço requisitado que está menos sobrecarregado para atender a requisição
 */
@RibbonClient(//Transformando nossa aplicação em RibbonCLient
		name = "hr-worker" //Nome do projeto que iremos consumir (Projeto que seremos o client) 
		) 
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
