package com.spring.security.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basic/")
public class BaiscController {

    @GetMapping("mybasic")
    public String login(){
        return "hello my name is jad";
    }

    @GetMapping("SecondeLogin")
    public String SecondeLogin(){
        return "My seconde login";
    }
}
