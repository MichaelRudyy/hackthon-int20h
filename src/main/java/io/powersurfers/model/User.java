package io.powersurfers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@org.springframework.data.mongodb.core.mapping.Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String email;
    private String name;
    @JsonIgnore
    private String password;
}
