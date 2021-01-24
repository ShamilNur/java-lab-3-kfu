package ru.kpfu.itis.group903.nurkaev.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String uuid;
}
