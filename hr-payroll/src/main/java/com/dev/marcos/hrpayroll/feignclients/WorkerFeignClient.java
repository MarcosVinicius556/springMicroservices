package com.dev.marcos.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.marcos.hrpayroll.entities.Worker;

/**
 * Antes de trabalharmos com as requisições feign,
 * precisaremos declarar uma interface, 
 * onde nela estarão contidas as assinaturas 
 * das requisições que desejamos fazer,
 * mantendo assim o código mais limpo,
 * além de também já ter integração com 
 * componentes do Spring Cloud
 */

@Component //Declarando como um componente gerenciado pelo Spring
@FeignClient( //Declarando como um client do Feign 
		name = "hr-worker", //Nome do projeto que iremos consumir
		url = "localhost:8001", //URL onde iremos buscar as informações
		path = "/workers" // endpoint da busca que iremos utilizar
		) 
public interface WorkerFeignClient {

	/**
	 * @apiNote método que irá buscar e retornar os dados 
	 * 			do worker através de uma requisição utilizando
	 * 			o Feign
	 * @param id
	 * @return ResponseEntity<Worker>
	 */
	@GetMapping( "/{id}" )
	ResponseEntity<Worker> findById(@PathVariable Long id);
	
}
