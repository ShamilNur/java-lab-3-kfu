package ru.kpfu.itis.group903.nurkaev.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.group903.nurkaev.exceptions.NoRoomsAvailableException;
import ru.kpfu.itis.group903.nurkaev.dto.AvailabilityDto;
import ru.kpfu.itis.group903.nurkaev.models.Room;
import ru.kpfu.itis.group903.nurkaev.services.RoomsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@WebServlet("/availability")
public class AvailabilityServlet extends HttpServlet {
    private RoomsService roomsService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        roomsService = (RoomsService) context.getAttribute("roomsService");
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/availability.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AvailabilityDto availabilityDto = objectMapper.readValue(req.getReader(), AvailabilityDto.class);

        List<Room> availableRooms;
        try {
            availableRooms = roomsService.getAvailableRooms(availabilityDto);
        } catch (NoRoomsAvailableException e) {
            availableRooms = roomsService.getAllRooms();
            req.setAttribute("noAvailableRooms",
                    "Нет доступных номеров с этими параметрами. Выберите самостоятельно среди всех.");
        }

        String roomsAsJson = objectMapper.writeValueAsString(availableRooms);
        resp.setContentType("application/json");
        resp.getWriter().println(roomsAsJson);
    }

}
