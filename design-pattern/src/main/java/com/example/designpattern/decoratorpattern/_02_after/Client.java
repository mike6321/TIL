package com.example.designpattern.decoratorpattern._02_after;

public class Client {

    private final CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    public void writeComment(String comment) {
        this.commentService.addComment(comment);
    }

}
