package io.powersurfers.datarest;

import io.powersurfers.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "Users", path = "users")
public interface UserRepoRest extends MongoRepository<User,String> {
    Optional<User> findById(@Param("id") String id);
    User findByEmail(@Param("email") String email);
    List<User> findByName(@Param("name")String name);
}
