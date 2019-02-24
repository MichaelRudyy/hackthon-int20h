package io.powersurfers.controller;

import io.powersurfers.model.User;
import io.powersurfers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    private ResponseEntity<User> getById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user == null) return new ResponseEntity<>(new User(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping("/byEmail")
    @ResponseStatus(HttpStatus.FOUND)
    private User getByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}
