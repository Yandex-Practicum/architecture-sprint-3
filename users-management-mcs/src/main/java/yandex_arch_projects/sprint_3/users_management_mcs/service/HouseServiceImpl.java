package yandex_arch_projects.sprint_3.users_management_mcs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yandex_arch_projects.sprint_3.users_management_mcs.dto.HouseDTO;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.House;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.User;
import yandex_arch_projects.sprint_3.users_management_mcs.repository.HouseRepository;
import yandex_arch_projects.sprint_3.users_management_mcs.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final UserRepository userRepository;

    @Override
    public List<House> getHousesByUserId(Long userId) {
        return houseRepository.findByUserId(userId);
    }

    @Override
    public void createUserHouse(HouseDTO updatedUserHouse) {
        House house = new House();
        house.setUserId(updatedUserHouse.getUserId());
        house.setStatus("NEW");
        house.setAddress(updatedUserHouse.getAddress());
        house.setCreatedAt(LocalDateTime.now());
        house.setUpdatedAt(LocalDateTime.now());
        houseRepository.save(house);
    }

    @Override
    public Optional<House> getHouse(Long houseId) {
        return houseRepository.findById(houseId);
    }

    @Override
    public void updateUserHouse(Long houseId, HouseDTO updatedDTO) {
        var optionalHouse = houseRepository.findById(houseId);
        if (optionalHouse.isPresent()) {
            House house = optionalHouse.get();
            house.setUserId(updatedDTO.getUserId());
            house.setAddress(updatedDTO.getAddress());
            house.setUpdatedAt(LocalDateTime.now());
            houseRepository.save(house);
        }
    }

    @Override
    public void deleteUserHouse(Long houseId) {
        if (houseRepository.findById(houseId).isPresent()) {
            houseRepository.deleteById(houseId);
        }
    }
}
