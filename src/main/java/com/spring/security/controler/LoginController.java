package com.spring.security.controler;


import com.spring.security.dto.ResponseLogin;
import com.spring.security.model.JwtLogin;
import com.spring.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

    private TokenService tokenService;
    @Autowired
    public LoginController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    // http://localhost:8080/signup
    @PostMapping("/signup")
    public ResponseLogin login(@RequestBody JwtLogin jwtLogin) throws Exception {
        return tokenService.successfulAuthentication(jwtLogin);
    }
}
