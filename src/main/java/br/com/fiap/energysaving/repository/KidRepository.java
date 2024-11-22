package br.com.fiap.energysaving.repository;

import br.com.fiap.energysaving.model.Kid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KidRepository extends JpaRepository<Kid, Long> {
}
