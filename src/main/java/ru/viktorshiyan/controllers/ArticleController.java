package ru.viktorshiyan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.viktorshiyan.domain.Article;
import ru.viktorshiyan.domain.Person;
import ru.viktorshiyan.repos.ArticleRepository;
import ru.viktorshiyan.repos.UserRepository;

@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("article")
    public @ResponseBody
    Article add(@RequestParam String title, @RequestParam String text, @RequestParam int person_id) {
        Person owner = userRepository.findById(person_id).orElseThrow(() -> new ArithmeticException());
        Article article = new Article();
        article.setOwner(owner);
        article.setText(text);
        article.setTitle(title);
        articleRepository.save(article);
        return article;
    }

    @GetMapping("article")
    public @ResponseBody
    Iterable<Article> getAll() {
        return articleRepository.findAll();
    }
}
