package br.com.fiap.energysaving.repository;

import br.com.fiap.energysaving.model.EnderecoUser;
import br.com.fiap.energysaving.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoUserRepository extends JpaRepository<EnderecoUser, Long> {
    List<EnderecoUser> findByUser(User user);
}
