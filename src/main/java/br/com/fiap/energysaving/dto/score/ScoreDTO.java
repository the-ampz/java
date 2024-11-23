package br.com.fiap.energysaving.dto.score;

import br.com.fiap.energysaving.dto.kid.KidDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record ScoreDTO(

        @Schema(description = "ID da pontuação.", example = "1")
        Long id,

        KidDTO kid,

        @Schema(description = "ID do desafio.", example = "101")
        Long challengeId,

        @Schema(description = "Valor dos pontos obtidos.", example = "50.0")
        Double points,

        @Schema(description = "Data de conclusão.", example = "2024-11-01")
        LocalDate completionDate
) {
}
