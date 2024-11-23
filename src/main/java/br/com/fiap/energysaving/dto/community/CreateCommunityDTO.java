package br.com.fiap.energysaving.dto.community;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCommunityDTO(

        @NotBlank
        @Schema(description = "Nome da comunidade.", example = "Comunidade Ecofiap")
        String name,

        @NotBlank
        @Schema(description = "Descrição da comunidade.", example = "Uma comunidade voltada para sustentabilidade.")
        String description,

        @NotNull
        @Schema(description = "Pontuação total inicial.", example = "100")
        Integer totalPoints
) {
}
