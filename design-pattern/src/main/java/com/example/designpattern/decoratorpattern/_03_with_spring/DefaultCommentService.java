package com.example.designpattern.decoratorpattern._03_with_spring;

public class DefaultCommentService implements CommentService {

    @Override
    public void addComment(String comment) {
        System.out.println(comment);
    }

}
