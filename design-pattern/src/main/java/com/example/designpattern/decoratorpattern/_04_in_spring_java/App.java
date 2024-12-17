package com.example.designpattern.decoratorpattern._04_in_spring_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(new Book());
        list.add(new Item());


        List<Book> books = Collections.checkedList(list, Book.class) ;
//        books.add(new Item());
    }

    private static class Book {

    }

    private static class Item {

    }

}
