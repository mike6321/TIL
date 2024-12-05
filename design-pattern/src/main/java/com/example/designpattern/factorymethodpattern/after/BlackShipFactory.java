package com.example.designpattern.factorymethodpattern.after;

public class BlackShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new BlackShip();
    }

}
