package com.example.http;

import lombok.Data;

@Data
public class ArticleDto {
    private String title;
    private String content;
}
/*
{
  "title": "제목이 여기 들어갑니다.",
  "content": "이것은 내용입니다."
}
 */
