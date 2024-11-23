package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_AMPZ_COMMUNITY_PARTICIPATION")
public class CommunityParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipation;

    @ManyToOne
    @JoinColumn(name = "id_kid", nullable = false)
    private Kid kid;

    @Column(name = "id_community", nullable = false)
    private Long idCommunity;

    private Integer points;
}
