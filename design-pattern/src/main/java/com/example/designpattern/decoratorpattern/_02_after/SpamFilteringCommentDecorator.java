package com.example.designpattern.decoratorpattern._02_after;

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
