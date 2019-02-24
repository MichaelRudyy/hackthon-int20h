package io.powersurfers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.List;

@Data
@org.springframework.data.mongodb.core.mapping.Document(value = "Documents")
public class Document {

    @Id
    private String id;

    private String title;

    private LocalDateTime modificationAt;

    @DBRef
    private User owner;

    @DBRef
    private List<Section> sections;
}
