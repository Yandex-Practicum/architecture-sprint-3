package yandex_arch_projects.sprint_3.device_management_mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yandex_arch_projects.sprint_3.device_management_mcs.entity.Telemetry;

public interface TelemetryRepository extends JpaRepository<Telemetry, Long> {
}
