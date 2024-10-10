package yandex_arch_projects.sprint_3.users_management_mcs.service;

import yandex_arch_projects.sprint_3.users_management_mcs.dto.HouseDTO;
import yandex_arch_projects.sprint_3.users_management_mcs.dto.UserDTO;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.House;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.User;

import java.util.List;
import java.util.Optional;

public interface HouseService {
    List<House> getHousesByUserId(Long userId);
    void createUserHouse(HouseDTO newUserHouse);
    Optional<House> getHouse(Long houseId);
    void deleteUserHouse(Long houseId);
    void updateUserHouse(Long houseId, HouseDTO updatedUserHouse);
}
