package ru.negrya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.negrya.dto.UserDto;
import ru.negrya.model.User;
import ru.negrya.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> gerUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public User updateUser(@RequestParam int id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping
    public User deleteUser(@RequestHeader int id) {
        return userService.deleteUser(id);
    }
}
