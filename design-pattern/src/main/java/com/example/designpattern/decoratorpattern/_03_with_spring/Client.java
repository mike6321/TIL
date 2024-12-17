package com.example.designpattern.decoratorpattern._03_with_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Client {

    private final CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    public void writeComment(String comment) {
        this.commentService.addComment(comment);
    }

}
