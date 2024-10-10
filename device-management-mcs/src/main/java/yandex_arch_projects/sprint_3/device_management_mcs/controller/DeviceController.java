package yandex_arch_projects.sprint_3.device_management_mcs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yandex_arch_projects.sprint_3.device_management_mcs.dto.DeviceDTO;
import yandex_arch_projects.sprint_3.device_management_mcs.entity.Device;
import yandex_arch_projects.sprint_3.device_management_mcs.entity.Telemetry;
import yandex_arch_projects.sprint_3.device_management_mcs.service.DeviceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping()
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }

    @PostMapping()
    public void createDevice(@RequestBody DeviceDTO newDevice) {
        deviceService.createDevice(newDevice);
    }

    @GetMapping("/{id}")
    public Optional<Device> getDeviceById(@PathVariable("id") Long id) {
        return deviceService.getDeviceById(id);
    }

    @PutMapping("/{id}")
    public void updateDevice(@PathVariable("id") Long id, @RequestBody DeviceDTO updatedDevice) {
        deviceService.updateDevice(id, updatedDevice);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable("id") Long id) {
        deviceService.deleteDevice(id);
    }

    @GetMapping("/{id}/telemetry")
    public Optional<Telemetry> getDeviceTelemetry(@PathVariable("id") Long id) {
        return deviceService.getDeviceTelemetry(id);
    }
}
