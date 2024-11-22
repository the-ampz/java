package br.com.fiap.energysaving.services;

import br.com.fiap.energysaving.dto.device.DeviceRequestDTO;
import br.com.fiap.energysaving.model.Device;
import br.com.fiap.energysaving.model.Kid;
import br.com.fiap.energysaving.repository.DeviceRepository;
import br.com.fiap.energysaving.repository.KidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private KidRepository kidRepository;

    public Device createDevice(DeviceRequestDTO deviceDTO, Long kidId) {
        Kid kid = kidRepository.findById(kidId).orElseThrow(() -> new RuntimeException("Kid not found"));
        Device device = new Device(
                null, // ID será gerado automaticamente
                deviceDTO.name(),
                deviceDTO.type(),
                deviceDTO.operatingSystem(),
                deviceDTO.energyConsumption(),
                deviceDTO.energySaved(),
                kid
        );
        return deviceRepository.save(device);
    }

    public Device getDevice(Long deviceId) {
        return deviceRepository.findById(deviceId).orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public Device updateDevice(Long deviceId, DeviceRequestDTO deviceDTO) {
        Device existingDevice = deviceRepository.findById(deviceId).orElseThrow(() -> new RuntimeException("Device not found"));
        existingDevice.setName(deviceDTO.name());
        existingDevice.setType(deviceDTO.type());
        existingDevice.setOperatingSystem(deviceDTO.operatingSystem());
        existingDevice.setEnergyConsumption(deviceDTO.energyConsumption());
        existingDevice.setEnergySaved(deviceDTO.energySaved());
        return deviceRepository.save(existingDevice);
    }

    public void deleteDevice(Long deviceId) {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new RuntimeException("Device not found"));
        deviceRepository.delete(device);
    }
}
