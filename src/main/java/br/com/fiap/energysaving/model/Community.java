package br.com.fiap.energysaving.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_GXP_COMMUNITY")
public class Community {
    @Id
    @GeneratedValue
    private Long id_community;

    private String ds_name;

    private String ds_description;

    private int total_points;
}
