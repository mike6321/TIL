package com.example.testcode.study.junit_in_action.step03.production;

public interface Controller {

    Response processRequest(Request request);
    void addHandler(Request request, RequestHandler requestHandler);

}
