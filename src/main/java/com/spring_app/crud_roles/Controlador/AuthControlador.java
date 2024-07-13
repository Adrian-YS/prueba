package com.spring_app.crud_roles.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthControlador {
    @GetMapping("/login")
    String login(){
        return "/login";
    }
}
