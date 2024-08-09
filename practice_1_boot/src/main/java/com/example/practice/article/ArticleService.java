package com.example.practice.article;

import com.example.practice.article.model.Article;
import com.example.practice.article.repo.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 비즈니스 로직을 담당하는 클래스
// 특정한 기능을 추가하고 싶을 때
// - 작성자 확인
// - 비속어 필터
// - 댓글을 작성할 때 게시글이 존재하는 게시글인지
@Service
public class ArticleService {
    private final ArticleRepository repository;
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    // Create
    public Article create(
            String title,
            String content,
            String writer
    ) {
        Article article = new Article(
                title,
                content,
                writer
        );
        return repository.save(article);
    }

    // Read All
    public List<Article> readAll() {
        return repository.findAll();
    }

    // Read One
    public Article readOne(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    // Update
    public Article update(
            Long id,
            String title,
            String content,
            String writer
    ) {
        Optional<Article> optionalTarget = repository.findById(id);
        if (optionalTarget.isEmpty()) {
            return null;
        }
        Article target = optionalTarget.get();
        target.setTitle(title);
        target.setContent(content);
        target.setWriter(writer);
        return repository.save(target);
    }

    // Delete
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
