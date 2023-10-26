package com.dev.marcos.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.hroauth.dto.UserLoginDTO;
import com.dev.marcos.hroauth.entities.User;
import com.dev.marcos.hroauth.services.TokenService;

@RestController
public class AuthResource {
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        loginDTO.email(), loginDTO.pass());

        Authentication authenticate = this.authenticationManager.authenticate(auth);

        User user = (User) authenticate.getPrincipal();

        return ResponseEntity.ok().body(tokenService.generateToken(user));
    }

}
