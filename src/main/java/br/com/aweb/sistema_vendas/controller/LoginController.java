package br.com.aweb.sistema_vendas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Página de login (o POST /login é processado pelo Spring Security)
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Página de confirmação de logout (o POST /logout é processado pelo Spring Security)
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
