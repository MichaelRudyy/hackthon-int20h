package io.powersurfers.model.document;

import lombok.Data;

@Data
public class Sentence {

    private int number;

    private String text;

    private Thesis thesis;
}
