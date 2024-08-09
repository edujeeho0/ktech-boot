package com.example.practice.article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("articles/{articleId}/comments")
public class CommentController {
    private final CommentService service;
    public CommentController(CommentService service) {
        this.service = service;
    }

    // CREATE
    // Comment는 Article에 종속되어 있으므로 URL 하나만 만들면 된다.
    // /articles/{articleId}/comments/create
    @PostMapping("create")
    public String create(
            @PathVariable("articleId")
            Long articleId,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer
    ) {
        service.create(articleId, content, writer);
        // POST - redirect - GET
        return String.format("redirect:/articles/%d", articleId);
    }
}
