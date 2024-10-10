package yandex_arch_projects.sprint_3.users_management_mcs.service;

import yandex_arch_projects.sprint_3.users_management_mcs.dto.UserDTO;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    void createUser(UserDTO newUser);
    Optional<User> getUser(Long id);
    void deleteUser(Long id);
    void updateUser(Long id, UserDTO updatedUser);
}
