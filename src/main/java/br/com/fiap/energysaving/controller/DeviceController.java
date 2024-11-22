package br.com.fiap.energysaving.controller;

import br.com.fiap.energysaving.dto.device.DeviceDTO;
import br.com.fiap.energysaving.dto.device.DeviceRequestDTO;
import br.com.fiap.energysaving.model.Device;
import br.com.fiap.energysaving.services.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Operation(summary = "Criar um novo dispositivo associado a uma criança", description = "Este endpoint cria um novo dispositivo associado a uma criança existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dispositivo criado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Criança não encontrada")
    })
    @PostMapping("/{kidId}")
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceDTO createDevice(@PathVariable Long kidId, @RequestBody DeviceRequestDTO deviceDTO) {
        Device device = deviceService.createDevice(deviceDTO, kidId);
        return new DeviceDTO(
                device.getIdDevice(),
                device.getName(),
                device.getType(),
                device.getOperatingSystem(),
                device.getEnergyConsumption(),
                device.getEnergySaved()
        );
    }

    @Operation(summary = "Buscar um dispositivo por ID", description = "Este endpoint retorna as informações de um dispositivo pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dispositivo encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dispositivo não encontrado")
    })
    @GetMapping("/{deviceId}")
    public DeviceDTO getDevice(@PathVariable Long deviceId) {
        Device device = deviceService.getDevice(deviceId);
        return new DeviceDTO(
                device.getIdDevice(),
                device.getName(),
                device.getType(),
                device.getOperatingSystem(),
                device.getEnergyConsumption(),
                device.getEnergySaved()
        );
    }

    @Operation(summary = "Atualizar um dispositivo", description = "Este endpoint atualiza as informações de um dispositivo existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dispositivo atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dispositivo não encontrado")
    })
    @PutMapping("/{deviceId}")
    public DeviceDTO updateDevice(@PathVariable Long deviceId, @RequestBody DeviceRequestDTO deviceDTO) {
        Device device = deviceService.updateDevice(deviceId, deviceDTO);
        return new DeviceDTO(
                device.getIdDevice(),
                device.getName(),
                device.getType(),
                device.getOperatingSystem(),
                device.getEnergyConsumption(),
                device.getEnergySaved()
        );
    }

    @Operation(summary = "Deletar um dispositivo", description = "Este endpoint deleta um dispositivo pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Dispositivo deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dispositivo não encontrado")
    })
    @DeleteMapping("/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDevice(@PathVariable Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }
}
