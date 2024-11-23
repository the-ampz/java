package br.com.fiap.energysaving.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_AMPZ_ADDRESS")
public class EnderecoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_address;

    private String ds_street;
    private String ds_number;
    private String ds_complement;
    private String ds_district;
    private String ds_city;
    private String ds_state;

    // Relacionamento com User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
