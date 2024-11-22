package br.com.fiap.energysaving.repository;

import br.com.fiap.energysaving.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("from User u where u.email = :email")
    User findByUserEmail(String email);
}

