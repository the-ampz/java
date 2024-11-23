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
@Table(name = "T_AMPZ_SCORE")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idScore;

    @ManyToOne
    @JoinColumn(name = "id_kid", nullable = false)
    private Kid kid;

    @Column(name = "id_challenge", nullable = false)
    private Long idChallenge;

    private Double vlPoints;

    private LocalDate dtCompletion;
}
