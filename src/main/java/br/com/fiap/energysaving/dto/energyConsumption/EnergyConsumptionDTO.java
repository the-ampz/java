package br.com.fiap.energysaving.dto.energyConsumption;

import br.com.fiap.energysaving.dto.device.DeviceDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record EnergyConsumptionDTO(

        @Schema(description = "ID do consumo de energia.", example = "1")
        Long id,

        DeviceDTO device,

        @Schema(description = "Tipo de consumo.", example = "Eletrodoméstico")
        String consumptionType,

        @Schema(description = "Valor do consumo de energia.", example = "250.5")
        Double consumptionValue,

        @Schema(description = "Quantidade de energia economizada.", example = "30.0")
        Double energySavedValue,

        @Schema(description = "Data do consumo.", example = "2024-11-01")
        LocalDate consumptionDate
) {
}
