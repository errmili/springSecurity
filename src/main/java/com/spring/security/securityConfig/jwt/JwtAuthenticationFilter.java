package com.spring.security.securityConfig.jwt;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.spring.springsecurity.model.JwtLogin;
//import com.spring.springsecurity.model.UserPrincipal;
import com.spring.security.model.JwtLogin;
import com.spring.security.model.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /* Trigger when we issue POST request to /login
  We also need to pass in {"username":"dan", "password":"dan123"} in the request body
   */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // Grab credentials and map them to login viewmodel
        JwtLogin credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), JwtLogin.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());
        // Authenticate user
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        return auth;
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Grab principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();
        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));
        // Add token in response
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX +  token);
    }

}
