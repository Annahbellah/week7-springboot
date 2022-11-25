package com.example.Week7.services;

import com.example.Week7.pojos.ApiResponse;
import com.example.Week7.pojos.NewsResponse;
import com.example.Week7.util.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewsService {

    private final HttpService httpService;
    private final ResponseManager responseManager;

    public ApiResponse getTopNews(){

        NewsResponse response = httpService.getNews();
        if(response.getTotalResults()>0)
            return responseManager.success(response.getArticles());

        return  responseManager.error("No news found");
    }
}
