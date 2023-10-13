package com.dev.marcos.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.hrworker.entities.Worker;
import com.dev.marcos.hrworker.services.WorkerService;

@RestController
@RequestMapping( "/workers" )
/**
 * A anotação refreshScope deve ser adicionada a 
 * toda classe que tiver acesso a qualquer tipo
 * de configuração do servidor.
 * Isto irá permitir que quando uma alteração
 * nas configurações seja realizada, o projeto
 * carregue as novas sem a necessidade de derrubar
 * e subir os projetos novamente
 * 
 */
@RefreshScope
public class WorkerResource {
	
	
	public static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	/**
	 * Acessando uma configuração do properties(ou yml)
	 */
	@Value("${test.config}")
	private String testConfig;

	@Autowired
	private WorkerService service;

	/**
	 * Buscando as configurações contidas no servidor de configuração
	 */
	@GetMapping("/configs")
	public ResponseEntity<Void> findConfig() {
		logger.info("Config = " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
}
