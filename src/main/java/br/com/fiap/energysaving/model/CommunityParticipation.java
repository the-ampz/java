package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_GXP_COMMUNITY_PARTICIPATION")
public class CommunityParticipation {
    @Id
    @GeneratedValue
    private Long id_participation;

    private int points;

    @ManyToOne
    @JoinColumn(name = "id_kid")
    private Kid kid;

    @ManyToOne
    @JoinColumn(name = "id_community")
    private Community community;
}
