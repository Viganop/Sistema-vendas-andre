package br.com.aweb.sistema_vendas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Pedidos é a área comum aos perfis ADMIN e PADRAO
        return "redirect:/pedidos";
    }
}