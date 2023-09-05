package com.example.java.effectivejava.item17;

public final class Person {

    // 가변적인 인스턴스를 막아야한다.
    private final Address address;

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Address getCloneAddress() {
        // 방어적인 복사
        Address copyOfAddress = new Address();
        copyOfAddress.setStreet(address.getStreet());
        copyOfAddress.setZipCode(address.getZipCode());
        return copyOfAddress;
    }

    public static void main(String[] args) {
        Address songPa = new Address();
        songPa.setStreet("songPa");
        Person person = new Person(songPa);

        Address address = person.getAddress();
        address.setStreet("gangDong");

        Address gangNam = new Address();
        gangNam.setStreet("gangNam");
        Person afterPerson = new Person(gangNam);
        Address cloneAddress = afterPerson.getCloneAddress();
        cloneAddress.setStreet("gangDong");

        System.out.println(afterPerson.getCloneAddress().getStreet());
    }

}
