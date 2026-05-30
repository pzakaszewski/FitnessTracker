package pl.wsb.fitnesstracker.user.api;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User createUser(User user);

    void deleteUser(Long userId);

    User updateUser(Long userId, UserDto userDto);

    List<User> findByEmailFragment(String emailFragment);

    List<User> findUsersOlderThan(LocalDate date);
}