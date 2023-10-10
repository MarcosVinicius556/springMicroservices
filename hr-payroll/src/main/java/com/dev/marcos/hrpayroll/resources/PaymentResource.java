package com.dev.marcos.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.hrpayroll.entities.Payment;
import com.dev.marcos.hrpayroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping( "/payments" )
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	/**
	 * Aqui estamos utilizando o Spring Cloud Circuit Breaker, 
	 * para casos onde um microsserviço não esteja rodando
	 * Nossa aplicação não irá "quebrar" e sim irá redirecionar nossa aplicação para 
	 * um outro método que irá tratar esta requisição
	 */
	@CircuitBreaker(name = "paymentAlternative", fallbackMethod = "getPaymentAlternative")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

	
	public ResponseEntity<Payment> getPaymentAlternative(@PathVariable Long workerId, @PathVariable Integer days, Throwable e) {
		Payment payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok(payment);
	}

}
