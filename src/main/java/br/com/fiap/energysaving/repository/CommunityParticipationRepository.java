package br.com.fiap.energysaving.repository;

import br.com.fiap.energysaving.model.CommunityParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityParticipationRepository extends JpaRepository<CommunityParticipation, Long> {
}
