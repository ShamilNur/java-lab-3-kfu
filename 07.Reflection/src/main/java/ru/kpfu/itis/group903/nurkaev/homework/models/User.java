package ru.kpfu.itis.group903.nurkaev.homework.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@Data
@Builder
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean isWorker;
}
