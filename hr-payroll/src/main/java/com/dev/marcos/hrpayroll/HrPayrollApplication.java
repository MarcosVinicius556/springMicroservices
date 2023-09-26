package com.dev.marcos.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Para que possa ser utilizado o feign no projeto,
 * e que o mesmo tenha uma instancia disponível para
 * a aplicação, é necessário utilizar esta anotação
 */
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
