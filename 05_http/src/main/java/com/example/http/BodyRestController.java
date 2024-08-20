package com.example.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Controller인데
// 모든 메서드에 @ResponseBody가 붙는 @Controller
public class BodyRestController {
    @GetMapping("/rest")
    public ResponseDto rest() {
        ResponseDto dto = new ResponseDto();
        dto.setStatus(200);
        dto.setMessage("OK");
        return dto;
    }

    @GetMapping("/rest-str")
    public String restStr() {
        return "Hello RestController";
    }
}
