package ru.kpfu.itis.group903.nurkaev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String uuid;

    public static boolean validate(UserDto userDto) {
        // непустое имя
        boolean firstNameValid = !userDto.firstName.equals("");
        // непустой пароль
        boolean lastNameValid = !userDto.lastName.equals("");
        // валидация email на основе специальной библиотеки
        boolean emailValid = EmailValidator.getInstance().isValid(userDto.email);
        // пароль не менее 3-х символов
        boolean passwordValid = userDto.password.length() >= 3;
        // проверка равенства основного пароля и пароля в поле подтверждения
        boolean confirmPasswordValid = userDto.password.equals(userDto.confirmPassword);

        return firstNameValid && lastNameValid && emailValid && passwordValid && confirmPasswordValid;
    }
}
