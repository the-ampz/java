package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.energyConsumption.CreateEnergyConsumptionDTO;
import br.com.fiap.energysaving.dto.energyConsumption.EnergyConsumptionDTO;
import br.com.fiap.energysaving.services.EnergyConsumptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy-consumptions")
@Tag(name = "Consumo de Energia", description = "Gerenciamento dos consumos de energia.")
public class EnergyConsumptionController {

    @Autowired
    private EnergyConsumptionService energyConsumptionService;

    @PostMapping
    @Operation(summary = "Criar um consumo de energia.")
    public EnergyConsumptionDTO create(@RequestBody @Valid CreateEnergyConsumptionDTO dto) {
        return energyConsumptionService.create(dto);
    }

    @GetMapping
    @Operation(summary = "Listar todos os consumos de energia.")
    public List<EnergyConsumptionDTO> findAll() {
        return energyConsumptionService.findAll();
    }
}
