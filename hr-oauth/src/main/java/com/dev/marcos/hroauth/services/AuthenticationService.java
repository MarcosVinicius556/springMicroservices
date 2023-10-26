package com.dev.marcos.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dev.marcos.hroauth.entities.User;
import com.dev.marcos.hroauth.feignclients.UserFeignClient;

public class AuthenticationService implements UserDetailsService{

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody(); 
        if(user == null){
            throw new UsernameNotFoundException("Email Not Found");
        }
        return user;
    }
    
}
