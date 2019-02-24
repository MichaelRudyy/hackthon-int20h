package io.powersurfers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Sentence {

    private String text;

    private Thesis thesis;
}
