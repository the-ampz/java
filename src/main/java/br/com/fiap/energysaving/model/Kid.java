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
@Table(name = "T_GXP_KID")
public class Kid {
    @Id
    @GeneratedValue
    private Long id_kid;

    private String ds_name;

    private Date dt_birthdate;

    private int total_score;

    private int total_energy_saved;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
