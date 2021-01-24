package ru.kpfu.itis.group903.nurkaev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group903.nurkaev.models.News;
import ru.kpfu.itis.group903.nurkaev.repositories.NewsRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 1
 */

@Service(value = "newsService")
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void save(News entity) {
        newsRepository.save(entity);
    }

    @Override
    public void delete(News entity) {
        newsRepository.delete(entity);
    }

    @Override
    public void update(News entity) {
        newsRepository.update(entity);
    }

    @Override
    public List<News> findByTag(String tagName) {
        return newsRepository.findByTag(tagName);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

}
