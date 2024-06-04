package com.example.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MvcController {

    @GetMapping("/posts/{id}")
    public Map<String, String> getPosts(@PathVariable(value = "id") Long id) throws Exception {
        Thread.sleep(300l);
        if (id > 10L) {
            throw new Exception("Too Long");
        }
        return Map.of("id", id.toString(), "content", "Posts content is %d".formatted(id));
    }

}
