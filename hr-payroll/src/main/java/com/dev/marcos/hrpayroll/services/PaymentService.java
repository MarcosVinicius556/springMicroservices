package com.dev.marcos.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.marcos.hrpayroll.entities.Payment;
import com.dev.marcos.hrpayroll.entities.Worker;
import com.dev.marcos.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerClient;
	
	public Payment getPayment( Long workerId, Integer days ) {
		Worker worker = workerClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
