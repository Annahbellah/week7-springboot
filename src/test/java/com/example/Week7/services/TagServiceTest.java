package com.example.Week7.services;
import com.example.Week7.pojos.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagServiceTest {

    @Autowired
    private  TagService tagService;

    @Test
    void addTag() {
        Tag newTag= new Tag();
        newTag.setId(1);
        newTag.setName("Java");
        assertEquals(true, tagService.addTag(newTag).isSuccess());
    }

    @Test
    void getTags(){
        assertEquals(true, tagService.getTags().isSuccess());
    }
}