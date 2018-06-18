package com.yuratrumpe.webserverboot.controller;

import com.yuratrumpe.webserverboot.model.User;
import com.yuratrumpe.webserverboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers() {

        return userService.getAllUsers();

    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PostMapping("")
    public User addUser(@RequestBody User user) {

        userService.addUser(user);

        return userService.getUserByName(user.getName());
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {

        if (userService.getUserById(id) == null)
            return null;

        user.setId(id);
        userService.updateUser(user);

        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable Long id) {

        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
        }

        return user;
    }

}
