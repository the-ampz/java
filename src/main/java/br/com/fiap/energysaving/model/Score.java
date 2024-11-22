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
@Table(name = "T_GXP_SCORE")
public class Score {
    @Id
    @GeneratedValue
    private Long id_score;

    private int vl_points;

    private Date dt_completion;

    @ManyToOne
    @JoinColumn(name = "id_kid")
    private Kid kid;

    @ManyToOne
    @JoinColumn(name = "id_challenge")
    private Challenge challenge;
}
