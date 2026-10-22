# Sistema de Vendas

Aplicações Web – Projeto 1 (Aplicações Monolíticas): camada de segurança com Spring Security e deploy no Render.

## Funcionalidades de segurança

- Spring Security com `ConfiguracoesDeSeguranca` (`@Configuration`, `@EnableWebSecurity`) no pacote `security`
- Login personalizado (`login.html`, `GET /login` no `LoginController`; `POST /login` processado pelo Spring)
- Logout personalizado (`logout.html`, `GET /logout`, formulário `POST /logout` redirecionando para `/login?logout`)
- Usuários no banco: `Usuario` (implementa `UserDetails`), `UsuarioRepository` (busca por e-mail ignorando caixa), `UsuarioService` (implementa `UserDetailsService`) e `BCryptPasswordEncoder` como `@Bean`; senhas sempre gravadas com hash
- Perfis `ADMIN` e `PADRAO` (`UsuarioRole`), com autorização visual (`sec:authorize` via Thymeleaf + Spring Security) e por URL (`requestMatchers`)

| Perfil | Produtos | Clientes | Pedidos |
|---|---|---|---|
| ADMIN | ✅ | ✅ | ✅ |
| PADRAO | ❌ (403) | ❌ (403) | ✅ |

## Usuários de teste

Criados automaticamente na primeira inicialização da aplicação:

| Perfil | E-mail | Senha |
|---|---|---|
| ADMIN | `admin@sistema.com` | `admin123` |
| PADRAO | `padrao@sistema.com` | `padrao123` |

## Executar localmente

```bash
docker compose up -d   # sobe o PostgreSQL na porta 5433
./mvnw spring-boot:run # aplicação em http://localhost:8080
```

## Situação do deploy no Render

O deploy no Render **não foi concluído** porque a plataforma exigiu cadastro de cartão de crédito/pagamento para criar os serviços, o que não foi possível realizar.

O que foi preparado:

- **Dockerfile** e **.dockerignore** prontos para o build no Render
- Configuração via variáveis de ambiente `DB_URL`, `DB_USER` e `DB_PASSWORD` em `application.properties` (com valores padrão para o ambiente local)
- Como alternativa ao PostgreSQL do Render, foi criado um banco PostgreSQL gratuito no **Neon** (região AWS US East 2 – Ohio), com conexão testada com sucesso

Com uma conta liberada no Render, basta criar um Web Service (Docker) apontando para este repositório e definir as três variáveis de ambiente.

A aplicação foi testada localmente com o `docker-compose.yml`: login, logout, bloqueio visual e bloqueio por URL para os dois perfis.
