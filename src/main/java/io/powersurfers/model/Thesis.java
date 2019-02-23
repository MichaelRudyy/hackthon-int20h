package io.powersurfers.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Thesis {

    private String text;

    private LocalDateTime modificatedAt;
}
