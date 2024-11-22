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
@Table(name = "T_GXP_CHALLENGE_GOAL")
public class Challenge {
    @Id
    @GeneratedValue
    private long id_challenge;

    private String ds_description;

    private int vl_score;

    private Date dt_start;

    private Date dt_end;

    private int vl_energy_required;

    @ManyToOne
    @JoinColumn(name = "id_community")
    private Community community;
}
