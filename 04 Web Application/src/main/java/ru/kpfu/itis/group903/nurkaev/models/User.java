package ru.kpfu.itis.group903.nurkaev.models;

import lombok.*;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    public User(Long id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
