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
@Table(name = "T_AMPZ_KID")
public class Kid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_KID")
    private Long idKid;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    @Column(name = "DS_NAME")
    private String name;

    @Column(name = "DT_BIRTHDATE")
    private LocalDate birthDate;

    @Column(name = "TOTAL_SCORE")
    private Integer totalScore;
}
