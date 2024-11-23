package br.com.fiap.energysaving.dto.community;

import io.swagger.v3.oas.annotations.media.Schema;

public record CommunityDTO(

        @Schema(description = "ID da comunidade.", example = "1")
        Long idCommunity,

        @Schema(description = "Nome da comunidade.", example = "Comunidade Ecofiap")
        String name,

        @Schema(description = "Descrição da comunidade.", example = "Uma comunidade voltada para sustentabilidade.")
        String description,

        @Schema(description = "Pontuação total.", example = "100")
        Integer totalPoints
) {
}
