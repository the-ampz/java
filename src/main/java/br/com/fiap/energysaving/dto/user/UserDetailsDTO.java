package br.com.fiap.energysaving.dto.user;

import br.com.fiap.energysaving.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record UserDetailsDTO(
        @Schema(description = "ID do usuário.", example = "1")
        Long id,

        @Schema(description = "Nome do usuário.", example = "Rafael Ronqui")
        String name,

        @Schema(description = "E-mail do usuário.", example = "rafael.ronqui@fiap.com.br")
        String email,

        @Schema(description = "Data de nascimento do usuário.", example = "1999-12-31")
        LocalDate birthDate

) {
    public UserDetailsDTO(User user){
        this(
                user.getId_user(),
                user.getName(),
                user.getEmail(),
                user.getBirthdate()
        );
    }
}
