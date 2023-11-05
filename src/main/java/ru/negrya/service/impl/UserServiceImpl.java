package ru.negrya.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.negrya.dto.UserDto;
import ru.negrya.model.User;
import ru.negrya.repository.UserRepository;
import ru.negrya.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int createUser(User user) {
       return userRepository.createUser(user);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User updateUser(int id, UserDto userDto) {
        return userRepository.updateUser(id, userDto);
    }

    public User deleteUser(int id) {
        return userRepository.deleteUser(id);
    }
}
