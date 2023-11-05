package ru.negrya.repository.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.negrya.dto.UserDto;
import ru.negrya.model.User;
import ru.negrya.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
   private static List<User> users =new ArrayList<>();
   private static int idGenerator;

    public int createUser(User user) {
        idGenerator++;
        user.setId(idGenerator);
        users.add(user);

        return idGenerator;
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public User getUserById(int id) {
       Optional<User> optionalUser = users.stream().filter(user -> user.getId() == id).findFirst();
       return optionalUser.orElseThrow(() -> new IllegalArgumentException("Пользователя с таким id не существует"));
//       if (optionalUser.isPresent()) {
//           return optionalUser.get();
//       } else {
//           throw new IllegalArgumentException("Пользователя с таким id не существует");
//       }
    }

    public User updateUser(int id, UserDto userDto) {
        User user = getUserById(id);
        user.setName(userDto.getName());
        user.setAdmin(userDto.isAdmin());
        return user;
    }

    public User deleteUser(int id) {
        User user = getUserById(id);
        users.remove(user);
        return user;
    }

}
