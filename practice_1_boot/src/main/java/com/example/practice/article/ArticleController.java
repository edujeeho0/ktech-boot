package com.example.practice.article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 사용자의 요청을 해석 및 처리 + 응답 전달
@Controller
@RequestMapping("articles")
public class ArticleController {
    private final ArticleService service;
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    // CREATE
    @GetMapping("create")
    public String createView() {
        return "articles/create.html";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer
    ) {
        Long id = service.create(title, content, writer).getId();
        // POST - redirect - GET
        return String.format("redirect:/articles/%d", id);
    }
}
