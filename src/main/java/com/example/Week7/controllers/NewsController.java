package com.example.Week7.controllers;

import com.example.Week7.pojos.ApiResponse;
import com.example.Week7.services.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/news")
@AllArgsConstructor
public class NewsController {

    private  final NewsService newsService;

    @GetMapping("/list")
    public ApiResponse getTopNews(){
        return newsService.getTopNews();
    }

}
