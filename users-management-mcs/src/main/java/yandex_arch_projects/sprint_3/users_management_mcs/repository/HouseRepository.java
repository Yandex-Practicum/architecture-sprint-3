package yandex_arch_projects.sprint_3.users_management_mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.House;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {
    List<House> findByUserId(Long userId);
}
