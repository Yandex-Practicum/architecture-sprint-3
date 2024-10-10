package yandex_arch_projects.sprint_3.device_management_mcs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import yandex_arch_projects.sprint_3.device_management_mcs.dto.DeviceDTO;
import yandex_arch_projects.sprint_3.device_management_mcs.entity.Device;
import yandex_arch_projects.sprint_3.device_management_mcs.entity.Telemetry;
import yandex_arch_projects.sprint_3.device_management_mcs.repository.DeviceRepository;
import yandex_arch_projects.sprint_3.device_management_mcs.repository.TelemetryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepo;
    private final TelemetryRepository teleRepo;

    @Override
    public List<Device> getDevices() {
        return deviceRepo.findAll();
    }

    @Override
    public void createDevice(DeviceDTO newDevice) {
        Device device = new Device();
        device.setUserId(newDevice.getUserId());
        device.setHouseId(newDevice.getHouseId());
        device.setStatus("NEW");
        device.setCreatedAt(LocalDateTime.now());
        device.setUpdatedAt(LocalDateTime.now());
        device.setDeviceType(newDevice.getDeviceType());
        device.setName(newDevice.getName());
        device.setSerialNumber(newDevice.getSerialNumber());
        deviceRepo.save(device);
    }

    @Override
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepo.findById(id);
    }

    @Override
    public void updateDevice(Long id, DeviceDTO updatedDevice) {
        var optionalDevice = deviceRepo.findById(id);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            device.setHouseId(updatedDevice.getHouseId());
            device.setBright(updatedDevice.getBright());
            device.setCurrentTemp(updatedDevice.getCurrentTemperature());
            device.setOpen(updatedDevice.isOpen());
            device.setUpdatedAt(LocalDateTime.now());
            deviceRepo.save(device);

        }
    }

    @Override
    public void deleteDevice(Long id) {
        if (deviceRepo.findById(id).isPresent()) {
            deviceRepo.deleteById(id);
        }
    }

    @Override
    public Optional<Telemetry> getDeviceTelemetry(Long id) {
        return teleRepo.findById(id);
    }
}
