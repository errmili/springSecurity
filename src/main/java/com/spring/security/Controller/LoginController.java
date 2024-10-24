package com.spring.security.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("api/")
public class LoginController {

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
