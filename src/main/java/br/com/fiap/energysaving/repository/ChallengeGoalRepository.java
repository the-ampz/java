package br.com.fiap.energysaving.repository;

import br.com.fiap.energysaving.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeGoalRepository extends JpaRepository<Challenge, Long> {
}
