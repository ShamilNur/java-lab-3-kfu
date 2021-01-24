package ru.kpfu.itis.group903.nurkaev.services;

import ru.kpfu.itis.group903.nurkaev.models.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    void save(News entity);
    void delete(News entity);
    void update(News entity);
    List<News> findByTag(String tagName);
    List<News> getAllNews();
}
