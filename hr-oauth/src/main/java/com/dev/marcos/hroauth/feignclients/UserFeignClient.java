package com.dev.marcos.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.marcos.hroauth.entities.User;

@Component //Componentes gerenciado pelo spring
@FeignClient( 
    name = "hr-user", //Nome do projeto que iremos se comunicar
    path = "/users" //Caminho onde o recurso será acessado
    )
public interface UserFeignClient {
    
    @GetMapping( "/search" )
	ResponseEntity<User> findByEmail(@RequestParam String email);

}
