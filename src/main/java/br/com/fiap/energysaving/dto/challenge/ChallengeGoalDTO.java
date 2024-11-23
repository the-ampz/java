package br.com.fiap.energysaving.dto.challengegoal;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record ChallengeGoalDTO(

        @Schema(description = "ID do desafio.", example = "1")
        Long idChallenge,

        @Schema(description = "Descrição do desafio.", example = "Economizar 10kWh em uma semana.")
        String description,

        @Schema(description = "Pontuação do desafio.", example = "100")
        Integer score,

        @Schema(description = "Data de início do desafio.", example = "2024-01-01")
        LocalDate startDate,

        @Schema(description = "Data de término do desafio.", example = "2024-01-07")
        LocalDate endDate,

        @Schema(description = "Energia necessária para completar o desafio (em kWh).", example = "10.0")
        Double energyRequired,

        @Schema(description = "ID da comunidade associada ao desafio.", example = "1")
        Long idCommunity
) {
}
