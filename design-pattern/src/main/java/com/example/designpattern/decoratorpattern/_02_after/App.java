package com.example.designpattern.decoratorpattern._02_after;

public class App {

    private static boolean enableSpamFiltering = true;
    private static boolean enableTrimmingComment = false;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();
        if (enableSpamFiltering) {
            commentService = new SpamFilteringCommentDecorator(commentService);
        }
        if (enableTrimmingComment) {
            commentService = new TrimmingCommentDecorator(commentService);
        }
        Client client = new Client(commentService);
        client.writeComment("Hello, http://www.example.com");
        client.writeComment("choijunwoo...");
    }

}
