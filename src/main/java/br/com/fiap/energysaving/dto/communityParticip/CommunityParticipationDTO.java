package br.com.fiap.energysaving.dto.communityParticip;

import br.com.fiap.energysaving.dto.kid.KidDTO;
import io.swagger.v3.oas.annotations.media.Schema;

public record CommunityParticipationDTO(

        @Schema(description = "ID da participação.", example = "1")
        Long idParticipation,

        KidDTO kid,

        @Schema(description = "ID da comunidade.", example = "1001")
        Long communityId,

        @Schema(description = "Pontuação obtida.", example = "20")
        Integer points
) {
}