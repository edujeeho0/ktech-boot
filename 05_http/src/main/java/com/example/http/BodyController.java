package com.example.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BodyController {
    // 응답이 HTML이 아니라, 객체의 데이터 그 자체가 되길 바란다면
    // @ResponseBody를 추가해준다.
    @PostMapping("/body")
    @ResponseBody
    public ResponseDto body(
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
}
