package ru.kpfu.itis.group903.nurkaev.filters;

import ru.kpfu.itis.group903.nurkaev.services.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class AuthFilter implements Filter {

    private UsersService usersService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Cookie[] cookies = req.getCookies();
        String cookieName = "Auth";
        if (cookies != null) {
            boolean containsAuthCookie = false;
            for (Cookie c : cookies) {
                System.out.println(c.getName());
                if (c.getName().equals(cookieName) && usersService.getUserSecondByUuid(c.getValue()).orElse(null) != null) {
                    containsAuthCookie = true;
                    break;
                }
            }

            if (!containsAuthCookie) {
                resp.sendRedirect("/signUp");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
