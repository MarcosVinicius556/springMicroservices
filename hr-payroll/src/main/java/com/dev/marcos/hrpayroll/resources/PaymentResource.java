package com.dev.marcos.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.hrpayroll.entities.Payment;
import com.dev.marcos.hrpayroll.services.PaymentService;

@RestController
@RequestMapping( "/payments" )
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	/* A rota será algo como: localhost:8080/payments/1/days/2 */
	@GetMapping( value = "/{workerId}/days/{days}" )
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok().body(payment);
	}
	
}
