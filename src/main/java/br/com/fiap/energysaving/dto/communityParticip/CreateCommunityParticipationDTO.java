package br.com.fiap.energysaving.dto.communityParticip;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record CreateCommunityParticipationDTO(

        @NotNull
        @Schema(description = "ID da criança.", example = "1")
        Long kidId,

        @NotNull
        @Schema(description = "ID da comunidade.", example = "1001")
        Long communityId,

        @Schema(description = "Pontuação obtida.", example = "20")
        Integer points
) {
}