//package ru.kpfu.itis.group903.nurkaev.servlets;
//
//import ru.kpfu.itis.group903.nurkaev.exceptions.WrongEmailOrPasswordException;
//import ru.kpfu.itis.group903.nurkaev.dto.LoginDto;
//import ru.kpfu.itis.group903.nurkaev.services.UsersService;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
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
//@WebServlet("/signIn")
//public class SignInServlet extends HttpServlet {
//    private UsersService usersService;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        ServletContext context = config.getServletContext();
//        usersService = (UsersService) context.getAttribute("usersService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//
//        LoginDto loginDto = LoginDto.builder()
//                .email(email)
//                .password(password)
//                .build();
//
//        try {
//            usersService.signIn(loginDto);
//            req.getSession().setAttribute("Email", email);
//            resp.sendRedirect("/main");
//            return;
//        } catch (WrongEmailOrPasswordException e) {
//            req.setAttribute("message", "Неправильный логин или пароль.");
//        }
//
//        req.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(req, resp);
//    }
//}
