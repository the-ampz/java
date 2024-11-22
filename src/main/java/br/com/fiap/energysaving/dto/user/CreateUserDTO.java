package br.com.fiap.energysaving.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateUserDTO(

        @Schema(description = "Nome do usuário.", example = "Rafael Ronqui")
        String name,

        @Email
        @Schema(description = "E-mail do usuário.", example = "rafael.ronqui@fiap.com.br")
        String email,

        @NotBlank @Size(min = 8)
        @Schema(description = "Senha do usuário.", example = "12345678")
        String password,

        @Past
        @Schema(description = "Data de nascimento do usuário.", example = "1999-12-31")
        LocalDate birthDate
) {

}
