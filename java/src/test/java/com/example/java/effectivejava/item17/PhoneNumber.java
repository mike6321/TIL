package com.example.java.effectivejava.item17;

public final class PhoneNumber {

    private final short areaCode, prefix, linenUm;

    public PhoneNumber(short areaCode, short prefix, short linenUm) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.linenUm = linenUm;
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLinenUm() {
        return linenUm;
    }

}
