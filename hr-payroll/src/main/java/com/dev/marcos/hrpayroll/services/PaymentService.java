package com.dev.marcos.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.marcos.hrpayroll.entities.Payment;
import com.dev.marcos.hrpayroll.entities.Worker;
import com.dev.marcos.hrpayroll.feignclients.WorkerFeignClient;

/**
 * Somente teremos os servicees, 
 * pois não teremos conexão com o banco de dados neste projeto
 */
@Service
public class PaymentService {

	/**
	 * Acessando uma variável disponível no application.properties e atribuindo o valor em um arquivo
	 * 
	 * Era utilizado com o restTemplate
	 */
//	@Value( "${hr-worker.host}" )
//	private String workerHost;
	
	/**
	 * Utilizando o bean que criamos na classe AppConfig
	 * 
	 * Não irá mais ser utilizado, apenas deixado para 
	 * saber que existe esta possibilidade
	 */
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	/**
	 * Método que ficará responsável por instanciar um pagamento, 
	 * Receberá o id do worker e irá buscar no prjeto hr-worker
	 * após isso irá criar um payment com base no worker e nos dias trabalhados 
	 * @param workerId
	 * @param days
	 * @return
	 * 
	 * Método comentado, pois estava utilizando o restTemplate
	 * E iremos utilizar uma abordagem mais moderna, Feign.
	 */
//	public Payment getPayment(Long workerId, Integer days) {
//		/**
//		 * Para fazer uma requisição com resttemplate será 
//		 * necessário passar um mapa com os parâmetros para a requisição
//		 */
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("id", workerId + ""); //Adicionando parâmetro do workerid
//		
//		/**
//		 * Fazendo a requisição e retornando o objeto necessário
//		 */
//		Worker worker = restTemplate.getForObject(
//				workerHost + "/workers/{id}", //Passando a rota da requisição para o resttemplate, com parâmetros variáveis
//				Worker.class, //Tipo do retorno da requisição
//				uriVariables//Parâmetros da requisição
//				); 
//		return new Payment(worker.getName(), worker.getDailyIncome(), days);
//	}
	
	public Payment getPayment(Long workerId, Integer days) {
		
		/**
		 * Fazendo a requisição e atribuindo o corpo dela para nosso worker
		 */
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
}
