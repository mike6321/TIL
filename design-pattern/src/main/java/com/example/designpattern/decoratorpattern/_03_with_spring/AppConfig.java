package com.example.designpattern.decoratorpattern._03_with_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.designpattern.decoratorpattern._03_with_spring")
public class AppConfig {

    @Bean
    public CommentService commentService() {
        CommentService commentService = new DefaultCommentService();

        boolean enableSpamFiltering = true;
        boolean enableTrimmingComment = true;

        if (enableSpamFiltering) {
            return new SpamFilteringCommentDecorator(commentService);
        }
        if (enableTrimmingComment) {
            return new TrimmingCommentDecorator(commentService);
        }
        return commentService;
    }

}
