package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_AMPZ_ENERGY_CONSUMPTION")
public class EnergyConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnergyConsumption;

    @ManyToOne
    @JoinColumn(name = "id_device", nullable = false)
    private Device device;

    private String dsConsumptionType;
    private Double vlConsumption;
    private Double vlEnergySaved;
    private LocalDate dtConsumption;
}
