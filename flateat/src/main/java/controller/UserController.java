
package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import converter.UserConverter;
import dto.User.UserDtoBase;
import dto.User.UserDtoW;
import entities.User;
import repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repo;

    @Autowired
    UserConverter conv;

    @GetMapping
    public List<UserDtoBase> getAllUsers() {
        return repo.findAll()
                .stream()
                .map(e -> conv.convertToDtoBase(e))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<UserDtoW> searchUsersByEmailAndPhone(@RequestParam String partialEmail, @RequestParam String phone) {
        List<User> usersByEmail = repo.findByEmailContaining(partialEmail);
        List<User> usersByPhone = repo.findByPhoneContaining(phone);
        

        List<User> intersection = usersByEmail.stream()
                .filter(usersByPhone::contains)
                .collect(Collectors.toList());

        return intersection.stream()
                .map(conv::convertToDtoW)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDtoW getUserById(@PathVariable Integer id) {
        return conv.convertToDtoW(repo.findById(id).orElse(null));
    }

    @PostMapping("/add")
    public UserDtoW addUser(@RequestBody UserDtoW userDto) {
        User user = conv.convertToEntity(userDto);
        return conv.convertToDtoW(repo.save(user));
    }

    @PutMapping("/{id}")
    public UserDtoW updateUser(@PathVariable Integer id, @RequestBody UserDtoW userDto) {
        User existingUser = repo.findById(id).orElse(null);
        if (existingUser != null) {
            User updatedUser = conv.convertToEntity(userDto);
            updatedUser.setId(id);
            return conv.convertToDtoW(repo.save(updatedUser));
        }
        return null;
    }
}
