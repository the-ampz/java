package br.com.fiap.energysaving.filter;

import br.com.fiap.energysaving.repository.UserRepository;
import br.com.fiap.energysaving.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String tokenJwt = request.getHeader("Authorization");

        if (tokenJwt != null && tokenJwt.startsWith("Bearer ")) {
            String token = tokenJwt.replace("Bearer ", "");
            try {
                // Extrair o usuário a partir do token
                String subject = tokenService.getSubject(token);
                var user = userRepository.findByEmail(subject);

                if (user != null) {
                    // Criar autenticação para o usuário
                    var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
                    throw new Exception("User not found");
                }
            } catch (Exception e) {
                // Retornar erro 403 caso algo falhe na validação do token
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.setContentType("application/json");
                response.getWriter().write("""
                    {
                        "message": "%s"
                    }
                """.formatted(e.getMessage()));
                return; // Encerrar o processamento da requisição
            }
        }

        // Prosseguir com a cadeia de filtros
        filterChain.doFilter(request, response);
    }
}
