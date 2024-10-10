package yandex_arch_projects.sprint_3.device_management_mcs.dto;

import lombok.Getter;

@Getter
public class DeviceDTO {
    private Long userId;
    private Long houseId;
    private String serialNumber;
    private String name;
    private String deviceType;
    private Long bright;
    private Long currentTemperature;
    private boolean isOpen;

}
