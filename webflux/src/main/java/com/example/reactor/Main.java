package com.example.reactor;

public class Main {

    public static void main(String[] args) {
        var publisher = new Publisher();
//        flux(publisher);
//        mono(publisher);
        emptyMono(publisher);
    }

    private static void flux(Publisher publisher) {
        publisher.startFlux()
                .subscribe(System.out::println);
    }

    private static void mono(Publisher publisher) {
        publisher.startMono()
                .subscribe();
    }

    private static void emptyMono(Publisher publisher) {
        publisher.startEmptyMono()
                .subscribe();
    }

}
