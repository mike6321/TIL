package com.example.java.multi_thread.string_split;

import org.junit.jupiter.api.Test;

class SplitComma2Test {

    @Test
    void split_test() {
        String lastName = getLastName("choi, junwoo", 3);
        System.out.println("lastName = " + lastName);
    }

    private String getLastName(String fullName, int index) {
        String[] splitName = new String[index];
        try {
            splitName = fullName.split(",");
            return splitName[2];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return splitName[2];
    }

}
