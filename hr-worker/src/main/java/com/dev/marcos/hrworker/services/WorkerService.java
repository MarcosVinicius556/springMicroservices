package com.dev.marcos.hrworker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.marcos.hrworker.entities.Worker;
import com.dev.marcos.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;
	
	public Worker findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Worker> findAll() {
		return repository.findAll();
	}
	
}
