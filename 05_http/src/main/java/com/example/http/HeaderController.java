package com.example.http;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@Controller
public class HeaderController {

    // @RequestHeader
    // 단일 헤더를 조회하여 사용하고 싶을 때
    @PostMapping("/header-one")
    public String getHeader(
            @RequestHeader("x-likelion")
            String header,
            Model model
    ) {
        model.addAttribute("message", header);
        return "done";
    }

    @PostMapping("/header-optional")
    public String getHeaderOptional(
            @RequestHeader(
                    value = "x-likelion",
                    required = false
            )
            String header,
            Model model
    ) {
        model.addAttribute("message", header);
        return "done";
    }

    @PostMapping("/header-int")
    public String getHeaderInt(
            @RequestHeader("x-likelion-int")
            Integer header,
            Model model
    ) {
        model.addAttribute("message", header);
        return "done";
    }

    @PostMapping("/header-all-1")
    // 헤더는 본질적으로 Key - Value 데이터다.
    // Java에서는 Map이 Key - Value로 데이터를 저장한다.
    public String getHeaderAll1(
            @RequestHeader
            Map<String, String> headerMap,
            Model model
    ) {
        for (Map.Entry<String, String> header: headerMap.entrySet()) {
            System.out.println(header.getKey() + ":" + header.getValue());
        }
        model.addAttribute("message", headerMap.toString());
        return "done";
    }

    @PostMapping("/header-all-2")
    public String getHeaderAll2(
            @RequestHeader
            HttpHeaders headers,
            Model model
    ) {
        for (Map.Entry<String, List<String>> header: headers.entrySet()) {
            System.out.println(header.getKey() + ":" + header.getValue());
        }
        model.addAttribute("message", headers.toString());
        return "done";
    }
}
