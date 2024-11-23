package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_AMPZ_COMMUNITY")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommunity;

    @Column(name = "ds_name", nullable = false, length = 100)
    private String name;

    @Lob
    @Column(name = "ds_description", nullable = false)
    private String description;

    @Column(name = "total_points", nullable = false)
    private Integer totalPoints;
}
