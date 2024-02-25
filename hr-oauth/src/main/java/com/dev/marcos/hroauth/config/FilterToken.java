package com.dev.marcos.hroauth.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dev.marcos.hroauth.entities.User;
import com.dev.marcos.hroauth.feignclients.UserFeignClient;
import com.dev.marcos.hroauth.services.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Definindo como um componente do spring
 * Assim o spring gerencia a injeção de
 * depêndencia desta classe
 **/
@Component
public class FilterToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token;

        System.out.println("Chegou no filtro de token...");

        String authorization = request.getHeader("Authorization"); //Pegamos o cabeçalho da requisição

        if(authorization != null){

            token = authorization.replace("Bearer", "");

            String subject = this.tokenService.getSubject(token);

            User user = this.userFeignClient.findByEmail(subject).getBody();

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
            
        }

        filterChain.doFilter(request, response);

    }
    
}
