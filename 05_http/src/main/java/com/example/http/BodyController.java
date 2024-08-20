package com.example.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BodyController {
    // 응답이 HTML이 아니라, 객체의 데이터 그 자체가 되길 바란다면
    // @ResponseBody를 추가해준다.
    @PostMapping("/body")
    @ResponseBody
    public ResponseDto bodyPost(
            // 요청을 JSON 등의 데이터로 받고 싶다면
            // @RequestBody를 추가해준다.
            @RequestBody
            ArticleDto request
    ) {
        System.out.println(request);
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setStatus(200);
        return response;
    }

    @GetMapping("/body")
    @ResponseBody
    public ArticleDto bodyGet() {
        ArticleDto article = new ArticleDto();
        article.setTitle("From Server");
        article.setContent("Hello World");
        return article;
    }

    @GetMapping("/body-str")
    @ResponseBody
    public String bodyStr() {
        return "Hello World!!!";
    }

    @PostMapping("/body-ac")
    @ResponseBody
    public ArticleCommentsDto bodyAc(
            @RequestBody
            ArticleCommentsDto dto
    ) {
        dto.getComments().add("new comment!!!");
        return dto;
    }

    @PostMapping("/body-entity")
    public ResponseEntity<ArticleDto> bodyEntity(
            @RequestBody
            ArticleDto dto
    ) {
//        ResponseEntity<ArticleDto> responseEntity =
//                new ResponseEntity<>(dto, HttpStatus.CREATED);

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-likelion-custom", "Hello World!!!");
//        ResponseEntity<ArticleDto> responseEntity =
//                new ResponseEntity<>(
//                        dto,
//                        headers,
//                        HttpStatus.ACCEPTED
//                );

//        ResponseEntity<ArticleDto> responseEntity = ResponseEntity
//                .accepted()
//                .header("x-likelion-one", "One Header")
//                .headers(headers)
//                .body(dto);

        ResponseEntity<ArticleDto> responseEntity = ResponseEntity
                .ok(dto);

        return responseEntity;
    }
}
