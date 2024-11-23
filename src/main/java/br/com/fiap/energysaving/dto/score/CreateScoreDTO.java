package br.com.fiap.energysaving.dto.score;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateScoreDTO(

        @NotNull
        @Schema(description = "ID da criança.", example = "1")
        Long kidId,

        @NotNull
        @Schema(description = "ID do desafio.", example = "101")
        Long challengeId,

        @Schema(description = "Valor dos pontos obtidos.", example = "50.0")
        Double points,

        @Schema(description = "Data de conclusão.", example = "2024-11-01")
        LocalDate completionDate
) {
}
