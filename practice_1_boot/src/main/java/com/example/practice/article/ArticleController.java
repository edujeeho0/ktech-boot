package com.example.practice.article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // READ ALL
    @GetMapping  // /articles
    public String readAll(Model model) {
        model.addAttribute("articles", service.readAll());
        return "articles/home.html";
    }

    // READ ONE
    //  /articles/1 => id = 1
    //  /articles/2 => id = 2
    //  /articles/3 => id = 3
    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article", service.readOne(id));
        return "articles/read.html";
    }
}
