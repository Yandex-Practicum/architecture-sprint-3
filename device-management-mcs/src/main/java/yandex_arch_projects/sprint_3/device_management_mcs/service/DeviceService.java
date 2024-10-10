package yandex_arch_projects.sprint_3.device_management_mcs.service;

import yandex_arch_projects.sprint_3.device_management_mcs.dto.DeviceDTO;
import yandex_arch_projects.sprint_3.device_management_mcs.entity.Device;
import yandex_arch_projects.sprint_3.device_management_mcs.entity.Telemetry;

import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Device> getDevices();
    void createDevice(DeviceDTO newDevice);
    Optional<Device> getDeviceById(Long id);
    void updateDevice(Long id, DeviceDTO updatedDevice);
    void deleteDevice(Long id);
    Optional<Telemetry> getDeviceTelemetry(Long id);
}
