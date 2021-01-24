package ru.kpfu.itis.group903.nurkaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.group903.nurkaev.dto.UserDto;
import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.services.UsersService;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Controller
public class SignUpController {
    private final UsersService usersService;

    @Autowired
    public SignUpController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping(value = "/signUp")
    public String signUpUser(Model model, UserDto userDto) {
        if (UserDto.validate(userDto)) {
            try {
                usersService.signUp(userDto);
                return "redirect:/signIn";
            } catch (DuplicateEntryException e) {
                model.addAttribute("message", "Пользователь с таким email уже существует.");
            }
        } else {
            model.addAttribute("message", "Вы ввели некорректные данные или заполнили не все поля.");
        }

        return "redirect:/signUp";
    }
}
