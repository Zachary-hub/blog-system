package com.zacharyhub.blogsystem.controller;

import com.zacharyhub.blogsystem.entity.Article;
import com.zacharyhub.blogsystem.entity.Blogger;
import com.zacharyhub.blogsystem.repository.ArticleRepository;
import com.zacharyhub.blogsystem.repository.BloggerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final BloggerRepository bloggerRepository;

    public ArticleController(ArticleRepository articleRepository,
                             BloggerRepository bloggerRepository) {

        this.articleRepository = articleRepository;
        this.bloggerRepository = bloggerRepository;
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {

        Blogger blogger = bloggerRepository
                .findById(article.getBlogger().getId())
                .orElse(null);

        article.setBlogger(blogger);

        return articleRepository.save(article);
    }
}