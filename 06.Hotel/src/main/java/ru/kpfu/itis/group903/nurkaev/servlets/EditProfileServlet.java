package ru.kpfu.itis.group903.nurkaev.servlets;

import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@WebServlet("/edit_profile")
public class EditProfileServlet extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("Email");
        Optional<User> userByEmailOptional = usersService.findOneByEmail(email);

        if (userByEmailOptional.isPresent()) {
            User user = userByEmailOptional.get();
            req.setAttribute("FirstName", user.getFirstName());
            req.setAttribute("LastName", user.getLastName());
        }

        req.getRequestDispatcher("/WEB-INF/views/editProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first-name");
        String lastName = req.getParameter("last-name");
        String email = req.getParameter("email");

        usersService.updateByEmail(firstName, lastName, email);
        resp.sendRedirect("/profile");
    }
}
