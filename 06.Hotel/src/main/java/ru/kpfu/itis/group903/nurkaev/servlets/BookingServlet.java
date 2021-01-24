package ru.kpfu.itis.group903.nurkaev.servlets;

import ru.kpfu.itis.group903.nurkaev.models.User;
import ru.kpfu.itis.group903.nurkaev.services.RoomsService;
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

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private UsersService usersService;
    private RoomsService roomsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
        roomsService = (RoomsService) context.getAttribute("roomsService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long roomId = Long.parseLong(req.getParameter("id"));
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("Email");

        Optional<User> userByEmailOptional = usersService.findOneByEmail(email);

        if (userByEmailOptional.isPresent() && roomsService.findById(roomId).isPresent()) {
            User user = userByEmailOptional.get();
            if (user.getRoomsId() != null) {
                user.setRoomsId(user.getRoomsId() + "," + roomId);
            } else {
                user.setRoomsId(String.valueOf(roomId));
            }

            usersService.update(user);
        }
    }

}
