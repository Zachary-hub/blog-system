package com.zacharyhub.blogsystem.controller;

import com.zacharyhub.blogsystem.entity.Blogger;
import com.zacharyhub.blogsystem.repository.BloggerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloggers")
public class BloggerController {

    private final BloggerRepository bloggerRepository;

    public BloggerController(BloggerRepository bloggerRepository) {
        this.bloggerRepository = bloggerRepository;
    }

    @GetMapping
    public List<Blogger> getAllBloggers() {
        return bloggerRepository.findAll();
    }

    @PostMapping
    public Blogger createBlogger(@RequestBody Blogger blogger) {
        return bloggerRepository.save(blogger);
    }

    @GetMapping("/{id}")
    public Blogger getBloggerById(@PathVariable Long id) {
        return bloggerRepository.findById(id).orElse(null);
    }


}