package com.dev.marcos.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.marcos.hrpayroll.entities.Payment;
import com.dev.marcos.hrpayroll.entities.Worker;

/**
 * Somente teremos os servicees, 
 * pois não teremos conexão com o banco de dados neste projeto
 */
@Service
public class PaymentService {

	/**
	 * Acessando uma variável disponível no application.properties e atribuindo o valor em um arquivo
	 */
	@Value( "${hr-worker.host}" )
	private String workerHost;
	
	/**
	 * Utilizando o bean que criamos na classe AppConfig
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Método que ficará responsável por instanciar um pagamento, 
	 * Receberá o id do worker e irá buscar no prjeto hr-worker
	 * após isso irá criar um payment com base no worker e nos dias trabalhados 
	 * @param workerId
	 * @param days
	 * @return
	 */
	public Payment getPayment(Long workerId, Integer days) {
		/**
		 * Para fazer uma requisição com resttemplate será 
		 * necessário passar um mapa com os parâmetros para a requisição
		 */
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId + ""); //Adicionando parâmetro do workerid
		
		/**
		 * Fazendo a requisição e retornando o objeto necessário
		 */
		Worker worker = restTemplate.getForObject(
				workerHost + "/workers/{id}", //Passando a rota da requisição para o resttemplate, com parâmetros variáveis
				Worker.class, //Tipo do retorno da requisição
				uriVariables//Parâmetros da requisição
				); 
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
