package com.example.http;

import lombok.Data;

import java.util.List;

@Data
public class ArticleCommentsDto {
    private String title;
    private String content;
    private WriterDto writer;
    private List<String> comments;
}
