package ru.viktorshiyan.repos;

import org.springframework.data.repository.CrudRepository;
import ru.viktorshiyan.domain.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
