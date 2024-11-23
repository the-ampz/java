package br.com.fiap.energysaving.dto.procedure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProcedureRequest {
    private String name;
    private String email;
    private String password;
    private Long addressId;
    private LocalDate birthdate;

    // Getters e Setters
}

