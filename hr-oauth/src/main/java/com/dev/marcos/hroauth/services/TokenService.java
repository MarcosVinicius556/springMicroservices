package com.dev.marcos.hroauth.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dev.marcos.hroauth.entities.User;

@Service
public class TokenService {
    
    private static final String ISSUER = "SpringMicrosservice";
    private static final String SECRET_WORD = "secret_word";

    /**
     * @apiNote Método responsável por criar um token
     *          personalizado a partir dos dados do 
     *          usuário que se logou 
     * @param usuario
     * @return String token de autenticação
     */
    public String generateToken(User usuario){
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(usuario.getEmail())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(SECRET_WORD));
    }

     /**
     * @apiNote Este método pega o token, verifica se está correto e válido 
     *          e retorna o subject dele
     * @param token
     * @return String subject
     */
    public String getSubject(String token){
        return JWT.require(Algorithm.HMAC256(SECRET_WORD))
                  .withIssuer(ISSUER)
                  .build()
                  .verify(token)
                  .getSubject();
    }

}
