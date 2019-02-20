package io.powersurfers.controller;

import io.powersurfers.data.UserRepository;
import io.powersurfers.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private Logger logger = LogManager.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> users() {
        List<User> users = (List<User>) userRepository.findAll();

        logger.error("Return list with {} users", users.size());

        return users;
    }
}
