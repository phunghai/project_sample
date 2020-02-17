package jp.co.htv.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
