package com.example.Week7.services;

import com.example.Week7.pojos.NewsResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HttpService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${news.apiKey}")
    private String accessKey;
    private String URL= "https://newsapi.org/v2/everything?q=tesla&from=2022-10-23&sortBy=publishedAt&apiKey="+accessKey;


    public NewsResponse getNews(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(URL, HttpMethod.GET, entity, NewsResponse.class).getBody();
    }
}
