package ru.kpfu.itis.group903.nurkaev.servlets;

import ru.kpfu.itis.group903.nurkaev.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // test save
        /*User user = new User(null, "Питер", "Паркер", 21);
        usersService.save(user);*/

        // test update and findById
        /*User user1 = new User(null, "Spider", "Man", 21);
        usersService.save(user1);
        user1.setFirstName("Человек");
        user1.setLastName("Паук");
        user1.setAge(22);
        usersService.update(user1);
        Optional<User> value = usersService.findById(2L);
        System.out.println(value.map(x -> "Hi," + x).orElse("Hi, anon"));*/

        // test delete
        /*User user2 = new User(null, "Alexander", "Brin", 40);
        usersService.save(user2);
        usersService.delete(user2);*/

        // test findAll
        /*System.out.println(usersService.getAllUsers());*/
        request.setAttribute("usersForJsp", usersService.getAllUsers());
        request.getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(request, response);

        // test findAllByAge
        /*System.out.println(usersService.getUsersByAge(18));*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        Cookie cookie = new Cookie("color", color);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(cookie);
        response.sendRedirect("/users");
    }
}
