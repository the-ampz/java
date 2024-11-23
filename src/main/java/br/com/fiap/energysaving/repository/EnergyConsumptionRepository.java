package br.com.fiap.energysaving.repository;

import br.com.fiap.energysaving.model.EnergyConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyConsumptionRepository extends JpaRepository<EnergyConsumption, Long> {
}
