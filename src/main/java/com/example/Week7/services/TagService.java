package com.example.Week7.services;

import com.example.Week7.pojos.ApiResponse;
import com.example.Week7.pojos.Tag;
import com.example.Week7.util.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TagService {

    private  final ResponseManager responseManager;
    private  ArrayList<Tag> tags;


    public ApiResponse addTag(Tag tag) {
        if (tag.getId() == 0)
            return responseManager.error("Id required");
        else if (tag.getName() == null)
            return responseManager.error("Name required");
        else{
            tags.add(tag);
            return  responseManager.success(tag);
        }
    }

    public ApiResponse getTags(){
        return   responseManager.success(tags);
    }
}
