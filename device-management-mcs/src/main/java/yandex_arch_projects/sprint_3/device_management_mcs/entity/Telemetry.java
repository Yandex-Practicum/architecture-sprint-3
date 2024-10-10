package yandex_arch_projects.sprint_3.device_management_mcs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "video_data")
@Getter
@Setter
public class Telemetry {

    @Id
    @Column(name="device_id")
    private Long deviceId;

    @OneToOne
    @JoinColumn(name="device_id", insertable=false, updatable=false)
    private Device device;

    @Column(name="video_json_data")
    private String videoData;

}
