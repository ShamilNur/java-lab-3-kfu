package ru.kpfu.itis.group903.nurkaev.repositories;

import ru.kpfu.itis.group903.nurkaev.models.News;

import java.util.List;

public interface NewsRepository extends CrudRepository<News> {
    List<News> findByTag(String tagName);
}
