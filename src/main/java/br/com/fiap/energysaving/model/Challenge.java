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
@Table(name = "T_AMPZ_CHALLENGE_GOAL")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChallenge;

    @Lob
    @Column(name = "ds_description", nullable = false)
    private String description;

    @Column(name = "vl_score", nullable = false)
    private Integer score;

    @Column(name = "dt_start", nullable = false)
    private LocalDate startDate;

    @Column(name = "dt_end", nullable = false)
    private LocalDate endDate;

    @Column(name = "vl_energy_required", nullable = false)
    private Double energyRequired;

    @ManyToOne
    @JoinColumn(name = "id_community", nullable = false)
    private Community community;
}
