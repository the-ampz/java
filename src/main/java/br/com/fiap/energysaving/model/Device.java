package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_AMPZ_DEVICE")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDevice;

    private String name;
    private String type;
    private String operatingSystem;
    private Double energyConsumption;
    private Double energySaved;

    // Relacionamento com Kid
    @ManyToOne
    @JoinColumn(name = "id_kid")
    private Kid kid;
}
