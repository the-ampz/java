package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_GXP_DEVICE")
public class Device {

    @Id
    @GeneratedValue
    private Long id_device;

    private String ds_name;

    private String ds_type;

    private String ds_operating_system;

    private int vl_energy_consumption;

    private int vl_energy_saved;

    @ManyToOne
    @JoinColumn(name = "id_kid")
    private Kid kid;
}
