package com.example.http;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping
// 어떤 HTTP 요청의 모양(데이터)에 따라
// 어떤 메서드가 실행되어야 할지를 결정하는 능력을 가지고 있다.
public class MappingController {
    // @RequestMapping의 다양한 사용법을 알아보자!
    // method로 어떤 HTTP method에 대해서 실행될지 결정 가능
    @RequestMapping(
            value = "/path",
            method = RequestMethod.GET
    )
    public String getPath(Model model) {
        model.addAttribute("message", "GET /path");
        return "done";
    }

    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST
    )
    public String postPath(Model model) {
        model.addAttribute("message", "POST /path");
        return "done";
    }

    @RequestMapping(
            value = "/path",
            method = { RequestMethod.PUT, RequestMethod.DELETE }
    )
    public String putOrDeletePath(Model model) {
        model.addAttribute("message", "PUT or DELETE /path");
        return "done";
    }

    // 상대방이 보낸 데이터에 따라서 다른 메서드를 실행해보기
    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String consumes(Model model) {
        model.addAttribute("message", "application/json");
        return "done";
    }

    // 상대방이 보낸 헤더에 따라서 다른 메서드를 실행해보기
    @RequestMapping(
            value = "/path",
            method = RequestMethod.POST,
            headers = "x-likelion=hello"
    )
    public String headers(Model model) {
        model.addAttribute("message", "headers");
        return "done";
    }

    // 상대방이 보낸 Query Parameter에 따라 다른 메서드를 실행해보기
    // /articles => 전체 게시글 조회
    // /articles?search="" => 전체 게시글 중 검색
    @RequestMapping(
            value = "/path",
            method = RequestMethod.GET,
            params = "search=hello"
    )
    public String getWithSearch(Model model) {
        model.addAttribute("message", "search");
        return "done";
    }


}
