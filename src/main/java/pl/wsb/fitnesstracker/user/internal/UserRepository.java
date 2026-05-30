package pl.wsb.fitnesstracker.user.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.wsb.fitnesstracker.user.api.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {

    default Optional<User> findByEmail(String email) {
        return findAll().stream()
                .filter(user -> Objects.equals(user.getEmail(), email))
                .findFirst();
    }

    default List<User> findByEmailFragment(String emailFragment) {
        return findAll().stream()
                .filter(user -> user.getEmail()
                        .toLowerCase()
                        .contains(emailFragment.toLowerCase()))
                .toList();
    }

    @Query("SELECT u FROM User u WHERE u.birthdate < :date")
    List<User> findUsersOlderThan(@Param("date") LocalDate date);
}