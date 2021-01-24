//package ru.kpfu.itis.group903.nurkaev.servlets;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import ru.kpfu.itis.group903.nurkaev.exceptions.DuplicateEntryException;
//import ru.kpfu.itis.group903.nurkaev.dto.UserDto;
//import ru.kpfu.itis.group903.nurkaev.models.User;
//import ru.kpfu.itis.group903.nurkaev.services.UsersService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Shamil Nurkaev @nshamil
// * 11-903
// * Sem 1
// */
//
//@WebServlet("/signUp")
//public class SignUpServlet extends HttpServlet {
//    @Autowired
//    private UsersService usersService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (User.validate(req, resp)) {
//            try {
//                UserDto userDto = UserDto.builder()
//                        .firstName(req.getParameter("firstName"))
//                        .lastName(req.getParameter("lastName"))
//                        .email(req.getParameter("email"))
//                        .password(req.getParameter("password"))
//                        .build();
//
//                usersService.signUp(userDto);
//                resp.sendRedirect("/signIn");
//                return;
//
//            } catch (DuplicateEntryException e) {
//                req.setAttribute("message", "Пользователь с таким email уже существует.");
//            }
//        } else {
//            req.setAttribute("message", "Вы ввели некорректные данные или заполнили не все поля.");
//        }
//
//        req.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(req, resp);
//    }
//}
