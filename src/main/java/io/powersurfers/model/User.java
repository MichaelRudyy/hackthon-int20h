package io.powersurfers.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "USER_LOGIN", unique = true, nullable = false, updatable = true)
    private String login;

    @Column(name = "USER_PW", length = 32, unique = false, nullable = false)
    private String password;

    @Column(name = "USER_REGISTRATION_TIME", unique = false)
    private LocalDateTime registrationDateTime;
}
