package io.powersurfers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Sentence {

    @Id
    private String id;

    private String text;

    private Thesis thesis;
}
