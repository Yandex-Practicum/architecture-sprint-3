package yandex_arch_projects.sprint_3.users_management_mcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yandex_arch_projects.sprint_3.users_management_mcs.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
