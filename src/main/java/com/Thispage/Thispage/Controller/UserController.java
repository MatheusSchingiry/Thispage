package com.Thispage.Thispage.Controller;

import com.Thispage.Thispage.Domain.User;
import com.Thispage.Thispage.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
