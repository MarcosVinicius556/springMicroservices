package com.dev.marcos.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.marcos.hrpayroll.entities.Worker;

@FeignClient( name = "hr-worker", path = "/workers" )
public interface WorkerFeignClient {

	@GetMapping
	ResponseEntity<Worker> findById(@PathVariable Long id);
	
}
