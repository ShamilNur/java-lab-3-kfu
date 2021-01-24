package ru.kpfu.itis.group903.nurkaev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String email;
    private String password;
}
