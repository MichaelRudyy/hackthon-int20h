package io.powersurfers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/{path:document}/**")
    public String forward(){
        return "forward:/";
    }
}
