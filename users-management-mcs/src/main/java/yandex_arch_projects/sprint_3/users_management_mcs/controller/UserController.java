package yandex_arch_projects.sprint_3.users_management_mcs.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yandex_arch_projects.sprint_3.users_management_mcs.dto.HouseDTO;
import yandex_arch_projects.sprint_3.users_management_mcs.dto.UserDTO;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.House;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.User;
import yandex_arch_projects.sprint_3.users_management_mcs.service.HouseService;
import yandex_arch_projects.sprint_3.users_management_mcs.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HouseService houseService;

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    public void createUser(@RequestBody UserDTO newUser) {
        userService.createUser(newUser);
    }

    @GetMapping(path = "{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id)  {
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserDTO updatedUser) {
        userService.updateUser(id, updatedUser);
    }

    @GetMapping("/{id}/houses")
    public List<House> getHouses(@PathVariable("id") Long userId) {
        return houseService.getHousesByUserId(userId);
    }

    @PostMapping("/houses")
    public void createUserHouse(@RequestBody HouseDTO updatedUserHouse) {
        houseService.createUserHouse(updatedUserHouse);
    }

    @GetMapping("/{userId}/houses/{houseId}")
    public Optional<House> getHouse(@PathVariable("houseId") Long houseId) {
        return houseService.getHouse(houseId);
    }

    @PutMapping("/{userId}/houses/{houseId}")
    public void updateUserHouse(@PathVariable("houseId") Long houseId, @RequestBody HouseDTO updatedHouse) {
        houseService.updateUserHouse(houseId, updatedHouse);
    }

    @DeleteMapping("/{userId}/houses/{houseId}")
    public void deleteUserHouse(@PathVariable("houseId") Long houseId) {
        houseService.deleteUserHouse(houseId);
    }
}
