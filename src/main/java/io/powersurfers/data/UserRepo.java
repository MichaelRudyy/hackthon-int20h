package io.powersurfers.data;

import io.powersurfers.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User,String> {
    Optional<User> findById(String id);
    User findByEmail(String email);
    List<User> findByName(String name);
}
