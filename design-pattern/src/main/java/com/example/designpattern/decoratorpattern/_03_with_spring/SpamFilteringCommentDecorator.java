package com.example.designpattern.decoratorpattern._03_with_spring;

public class SpamFilteringCommentDecorator extends CommentDecorator {

    public SpamFilteringCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        if (!isSpam(comment)) {
            System.out.println("Spam detected!");
        }
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }

}
