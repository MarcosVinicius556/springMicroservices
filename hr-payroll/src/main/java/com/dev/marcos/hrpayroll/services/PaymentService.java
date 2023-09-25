package com.dev.marcos.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.dev.marcos.hrpayroll.entities.Payment;

/**
 * Somente teremos os servicees, 
 * pois não teremos conexão com o banco de dados neste projeto
 */
@Service
public class PaymentService {

	/**
	 * Método que ficará responsável por instanciar um pagamento, 
	 * Receberá o id do worker e irá buscar no prjeto hr-worker
	 * após isso irá criar um payment com base no worker e nos dias trabalhados 
	 * @param workerId
	 * @param days
	 * @return
	 */
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bob", 200.0, days);
	}
	
}
