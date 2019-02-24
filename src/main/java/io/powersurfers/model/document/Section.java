package io.powersurfers.model.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@org.springframework.data.mongodb.core.mapping.Document(value = "Sections")
public class Section {
    @Id
    private String id;

    private int number;

    private String title;

    private Status status;

    private Iterable<Sentence> sentences;

    public enum Status {
        PASSED, ACTIVE, NOTPASSED
    }
}
