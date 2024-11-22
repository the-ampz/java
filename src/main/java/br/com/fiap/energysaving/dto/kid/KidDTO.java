package br.com.fiap.energysaving.dto.kid;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record KidDTO(

        @Schema(description = "ID da criança.", example = "2")
        Long idKid,

        @Schema(description = "Nome da criança.", example = "João Silva")
        String name,

        @Schema(description = "Data de nascimento da criança.", example = "2010-05-15")
        LocalDate birthDate,

        @Schema(description = "Pontuação total da criança.", example = "85")
        Integer totalScore

) {
}
