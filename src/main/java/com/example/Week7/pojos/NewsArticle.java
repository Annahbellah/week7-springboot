package com.example.Week7.pojos;

import lombok.Data;

@Data
public class NewsArticle {
    private NewsSource source;
    private String author;
    private String title;
    private  String description;
    private  String content;
    private  String url;
    private  String urlToImage;
    private String publishedAt;
}
