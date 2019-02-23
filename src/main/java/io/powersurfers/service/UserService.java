package io.powersurfers.service;

import io.powersurfers.data.UserRepo;
import io.powersurfers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(String id) {
        return userRepo.findById(id).orElse(null);
    }

    public User getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public Iterable<User> getUsersByName(String name){
        return userRepo.findByName(name);
    }
}
