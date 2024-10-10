package yandex_arch_projects.sprint_3.users_management_mcs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yandex_arch_projects.sprint_3.users_management_mcs.dto.UserDTO;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.User;
import yandex_arch_projects.sprint_3.users_management_mcs.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(UserDTO newUser) {
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setStatus("ACTIVE");
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public void updateUser(Long id, UserDTO updatedUser) {

        var optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(updatedUser.getEmail());
            user.setUpdatedAt(LocalDateTime.now());
            userRepository.save(user);

        }
    }

}
