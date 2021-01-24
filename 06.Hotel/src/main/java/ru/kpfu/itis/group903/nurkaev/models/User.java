package ru.kpfu.itis.group903.nurkaev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
    private String roomsId;

    public static boolean validate(HttpServletRequest req, HttpServletResponse resp) {
        // непустое имя
        boolean firstNameValid = !req.getParameter("firstName").equals("");
        // непустой пароль
        boolean lastNameValid = !req.getParameter("lastName").equals("");
        // валидация email на основе специальной библиотеки
        boolean emailValid = EmailValidator.getInstance().isValid(req.getParameter("email"));
        // пароль не менее 3-х символов
        boolean passwordValid = req.getParameter("password").length() >= 3;
        // проверка равенства основного пароля и пароля в поле подтверждения
        boolean confirmPasswordValid = req.getParameter("password").equals(req.getParameter("confirm_password"));

        return firstNameValid && lastNameValid && emailValid && passwordValid && confirmPasswordValid;
    }
}
