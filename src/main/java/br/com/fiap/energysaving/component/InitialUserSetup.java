package br.com.fiap.energysaving.component;

import br.com.fiap.energysaving.model.User;
import br.com.fiap.energysaving.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class InitialUserSetup {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createInitialUser() {
        // Verifica se já existe um usuário no banco
        if (userRepository.count() == 0) {
            // Cria um usuário inicial
            User adminUser = new User(
                    "Admin",
                    "admin@example.com",
                    passwordEncoder.encode("admin123"),
                    null
            );

            userRepository.save(adminUser);
            System.out.println("Usuário inicial criado com e-mail: admin@example.com e senha: admin123");
        }
    }
}
