package ru.kpfu.itis.group903.nurkaev.servlets;

import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
import ru.kpfu.itis.group903.nurkaev.forms.UserForm;
import ru.kpfu.itis.group903.nurkaev.services.UsersService;
import ru.kpfu.itis.group903.nurkaev.validations.Validator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Validator.dataIsCorrect(req, resp)) {
            try {
                UserForm userForm = UserForm.builder()
                        .firstName(req.getParameter("firstName"))
                        .lastName(req.getParameter("lastName"))
                        .email(req.getParameter("email"))
                        .password(req.getParameter("password"))
                        .uuid(UUID.randomUUID().toString())
                        .build();

                usersService.signUp(userForm);

                String uuid = userForm.getUuid();
                Cookie cookie = new Cookie("Auth", uuid);
                cookie.setMaxAge(60 * 60 * 24 * 365);
                resp.addCookie(cookie);
                resp.sendRedirect("/users");
                return;
            } catch (DuplicateEntryException e) {
                req.setAttribute("message", "User with such email already exists.");
            }
        } else {
            req.setAttribute("message", "You have to fill all the forms.");
        }

        req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
    }
}
