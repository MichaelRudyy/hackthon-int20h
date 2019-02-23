package io.powersurfers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Section {
    @Id
    private String id;

    private String text;

    private Iterable<Sentence> sentences;
}
