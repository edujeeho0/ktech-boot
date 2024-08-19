package com.example.http;

import lombok.Data;

@Data
public class ResponseDto {
    private Integer status;
    private String message;
}
/*
{
  "status": 200,
  "message": "OK"
}
 */
