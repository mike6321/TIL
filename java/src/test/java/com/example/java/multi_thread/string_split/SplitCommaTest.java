package com.example.java.multi_thread.string_split;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SplitCommaTest {

    @Test
    void split_test() {
        String lastName = getLastName("choi, junwoo", 3);
        System.out.println(lastName);
    }

    private String getLastName(String fullName, Integer listSize) {
        List<String> stringList = new ArrayList<>(Collections.nCopies(listSize, ""));
        stringList.addAll(Arrays.asList(fullName.split(",")));

        return stringList.get(2);
    }

}
