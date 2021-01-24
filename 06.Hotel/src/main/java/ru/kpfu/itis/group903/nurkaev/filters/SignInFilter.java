package ru.kpfu.itis.group903.nurkaev.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

public class SignInFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Object email = session.getAttribute("Email");
        if (email != null) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/signUp");
        }
    }
}
