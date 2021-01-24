package ru.kpfu.itis.group903.nurkaev;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

/*
 * Класс, на основе которого будет сгенерирована форма.
 * Форма автоматически создастся в момент компиляции.
 */
@HtmlForm(method = "post", action = "/user")
public class User {
    @HtmlInput(name = "nickname", placeholder = "Ваш ник") // декларирующая аннотация
    private String nickname;
    @HtmlInput(type = "email", name = "email", placeholder = "Ваша почта")
    private String email;
    @HtmlInput(type = "password", name = "password", placeholder = "Пароль")
    private String password;
}
