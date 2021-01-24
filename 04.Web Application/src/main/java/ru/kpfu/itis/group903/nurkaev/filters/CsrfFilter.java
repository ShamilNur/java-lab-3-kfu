package ru.kpfu.itis.group903.nurkaev.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class CsrfFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getMethod().equals("GET")) {
            String csrf = UUID.randomUUID().toString();
            request.setAttribute("_csrf_token", csrf);
            if (request.getSession().getAttribute("_csrf_tokens_list") == null) {
                request.getSession().setAttribute("_csrf_tokens_list", new ArrayList<String>());
            } else {
                ((ArrayList<String>) request.getSession().getAttribute("_csrf_tokens_list")).add(csrf);
            }
        } else if (request.getMethod().equals("POST")) {
            String requestCsrf = request.getParameter("_csrf_token");
            ArrayList<String> sessionsCsrf =
                    (ArrayList<String>) request.getSession().getAttribute("_csrf_tokens_list");
            if (sessionsCsrf.contains(requestCsrf)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect("/users");
            }
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}