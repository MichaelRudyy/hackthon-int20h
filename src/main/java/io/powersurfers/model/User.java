package io.powersurfers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@org.springframework.data.mongodb.core.mapping.Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String email;
    private String name;
}
