package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_GXP_ENERGY_CONSUMPTION")
public class ConsumptionEnergy {
    @Id
    @GeneratedValue
    private long id_energy_consumption;

    private String ds_consumption_type;

    private int vl_consumption;

    private int vl_energy_saved;

    private Date dt_consumption;

    @ManyToOne
    @JoinColumn(name = "id_device")
    private Device device;

}
