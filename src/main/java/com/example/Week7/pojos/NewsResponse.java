package com.example.Week7.pojos;

import lombok.Data;

@Data
public class NewsResponse {
    private  String status;
    private  int totalResults;
    private  NewsArticle[] articles;
}
