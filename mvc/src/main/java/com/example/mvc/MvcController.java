package com.example.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MvcController {

    @GetMapping("/posts/{id}")
    public Map<String, String> getPosts(@PathVariable(value = "id") Long id) {
        return Map.of("id", id.toString(), "content", "Posts content is %d".formatted(id));
    }

}
