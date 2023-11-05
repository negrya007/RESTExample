package ru.negrya.service;

import ru.negrya.dto.UserDto;
import ru.negrya.model.User;

import java.util.List;

public interface UserService {
    int createUser(User user);

    List<User> getUsers();

    User getUserById(int id);

    User updateUser(int id, UserDto userDto);

    User deleteUser(int id);
}
