package br.com.aweb.sistema_vendas.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.aweb.sistema_vendas.model.UsuarioRole;
import br.com.aweb.sistema_vendas.service.UsuarioService;

// Cadastra os usuários de teste (ADMIN e PADRAO) caso ainda não existam no banco
@Component
public class UsuariosIniciais implements CommandLineRunner {

    private final UsuarioService usuarioService;

    @Value("${app.admin.senha:admin123}")
    private String senhaAdmin;

    @Value("${app.padrao.senha:padrao123}")
    private String senhaPadrao;

    public UsuariosIniciais(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(String... args) {
        usuarioService.criarSeNaoExistir("Administrador", "admin@sistema.com", senhaAdmin, UsuarioRole.ADMIN);
        usuarioService.criarSeNaoExistir("Usuário Padrão", "padrao@sistema.com", senhaPadrao, UsuarioRole.PADRAO);
    }
}
