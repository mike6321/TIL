package com.example.designpattern.factorymethod.after;

public class Client {

    public static void main(String[] args) {
        ShipFactory whiteShipFactory = new WhiteShipFactory();
        Ship whiteship = whiteShipFactory.orderShip("Whiteship", "junwoo.choi@gmail.com");
        System.out.println(whiteship);

        ShipFactory blackShipFactory = new BlackShipFactory();
        Ship blackShip = blackShipFactory.orderShip("BlackShip", "junwoo.choi@gmail.com");
        System.out.println(blackShip);
    }

}
