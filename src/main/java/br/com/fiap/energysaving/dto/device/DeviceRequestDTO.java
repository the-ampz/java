package br.com.fiap.energysaving.dto.device;

import io.swagger.v3.oas.annotations.media.Schema;

public record DeviceRequestDTO(

        @Schema(description = "Nome do dispositivo.", example = "Ar-condicionado")
        String name,

        @Schema(description = "Tipo do dispositivo.", example = "Eletrônico")
        String type,

        @Schema(description = "Sistema operacional do dispositivo.", example = "Android")
        String operatingSystem,

        @Schema(description = "Consumo de energia do dispositivo.", example = "150.5")
        Double energyConsumption,

        @Schema(description = "Energia economizada pelo dispositivo.", example = "30.5")
        Double energySaved

) {
}
