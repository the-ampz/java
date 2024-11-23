package br.com.fiap.energysaving.services;

import br.com.fiap.energysaving.dto.device.DeviceDTO;
import br.com.fiap.energysaving.dto.energyConsumption.CreateEnergyConsumptionDTO;
import br.com.fiap.energysaving.dto.energyConsumption.EnergyConsumptionDTO;
import br.com.fiap.energysaving.model.Device;
import br.com.fiap.energysaving.model.EnergyConsumption;
import br.com.fiap.energysaving.repository.DeviceRepository;
import br.com.fiap.energysaving.repository.EnergyConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyConsumptionService {

    @Autowired
    private EnergyConsumptionRepository energyConsumptionRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public EnergyConsumptionDTO create(CreateEnergyConsumptionDTO dto) {
        Device device = deviceRepository.findById(dto.deviceId())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        EnergyConsumption energyConsumption = new EnergyConsumption();
        energyConsumption.setDevice(device);
        energyConsumption.setDsConsumptionType(dto.consumptionType());
        energyConsumption.setVlConsumption(dto.consumptionValue());
        energyConsumption.setVlEnergySaved(dto.energySavedValue());
        energyConsumption.setDtConsumption(dto.consumptionDate());

        energyConsumptionRepository.save(energyConsumption);

        return new EnergyConsumptionDTO(
                energyConsumption.getIdEnergyConsumption(),
                new DeviceDTO(device.getIdDevice(), device.getName(), device.getType(), device.getOperatingSystem(),
                        device.getEnergyConsumption(), device.getEnergySaved()),
                energyConsumption.getDsConsumptionType(),
                energyConsumption.getVlConsumption(),
                energyConsumption.getVlEnergySaved(),
                energyConsumption.getDtConsumption()
        );
    }

    public List<EnergyConsumptionDTO> findAll() {
        return energyConsumptionRepository.findAll().stream().map(energyConsumption -> new EnergyConsumptionDTO(
                energyConsumption.getIdEnergyConsumption(),
                new DeviceDTO(
                        energyConsumption.getDevice().getIdDevice(),
                        energyConsumption.getDevice().getName(),
                        energyConsumption.getDevice().getType(),
                        energyConsumption.getDevice().getOperatingSystem(),
                        energyConsumption.getDevice().getEnergyConsumption(),
                        energyConsumption.getDevice().getEnergySaved()
                ),
                energyConsumption.getDsConsumptionType(),
                energyConsumption.getVlConsumption(),
                energyConsumption.getVlEnergySaved(),
                energyConsumption.getDtConsumption()
        )).toList();
    }
}
