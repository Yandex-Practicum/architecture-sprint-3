package yandex_arch_projects.sprint_3.device_management_mcs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="devices")
@Getter
@Setter
public class Device {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="house_id")
    private Long houseId;

    @Column
    private String status;

    @Column(name="current_temperature")
    private Long currentTemp;

    @Column
    private Long bright;

    @Column(name="is_open")
    private boolean isOpen;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="device_type_code")
    private String deviceType;

    @Column
    private String name;

    @Column(name="serial_number")
    private String serialNumber;

}
