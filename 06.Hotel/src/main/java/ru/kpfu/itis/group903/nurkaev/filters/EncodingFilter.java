//package ru.kpfu.itis.group903.nurkaev.filters;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
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
//public class EncodingFilter extends HttpFilter {
//
//    @Override
//    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//
//        chain.doFilter(req, resp);
//    }
//}
