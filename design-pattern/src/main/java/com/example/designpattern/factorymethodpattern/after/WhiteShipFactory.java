package com.example.designpattern.factorymethodpattern.after;

public class WhiteShipFactory implements ShipFactory{

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }

}
