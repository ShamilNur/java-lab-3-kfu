package ru.kpfu.itis.group903.nurkaev.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.group903.nurkaev.models.News;
import ru.kpfu.itis.group903.nurkaev.models.Tag;
import ru.kpfu.itis.group903.nurkaev.services.NewsService;

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

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    private NewsService newsService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        newsService = (NewsService) context.getAttribute("newsService");
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/news.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tag tag = objectMapper.readValue(req.getReader(), Tag.class);

        List<News> newsByTagName = newsService.findByTag(tag.getTagName());

        String newsByTagNameAsJson = objectMapper.writeValueAsString(newsByTagName);
        resp.setContentType("application/json");
        resp.getWriter().println(newsByTagNameAsJson);
    }

}
