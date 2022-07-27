package com.example.testcode.study.argument_capture_test.production;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    public String save(String var) {
        return var;
    }

}
