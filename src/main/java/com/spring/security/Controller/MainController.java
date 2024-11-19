package com.spring.security.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/")
public class MainController {

    @GetMapping("main")
    public String login(){
        return "index";
    }

    @GetMapping("fr")
    public String fr(){
        return "fragments";
    }

    @GetMapping("profile")
    public String profile(){
        return "profile/index";
    }

    @GetMapping("mange")
    public String mange(){
        return "management/index";
    }

    @GetMapping("admin")
    public String admin(){
        return "admin/index";
    }

    @GetMapping("admin/myadmin")
    public String myadmin(){
        return "admin/myadmin";
    }
}
