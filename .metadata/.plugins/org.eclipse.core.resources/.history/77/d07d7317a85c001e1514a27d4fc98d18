package com.dev.marcos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.entities.Worker;
import com.dev.marcos.repositories.WorkerRepository;

@RestController
@RequestMapping( "/workers" )
public class WorkerResource {
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping( "/{id}" )
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		Worker worker = repository.findById(id).get();
		return ResponseEntity.ok().body(worker);
	}

}
