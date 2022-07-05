package com.example.testcode.junit_in_action.step03.production;

public class ErrorResponse implements Response {

    private Request originalRequest;
    private Exception originException;

    public ErrorResponse(Request request, Exception e) {
        this.originalRequest = request;
        this.originException = e;
    }

    public Request getOriginalRequest() {
        return originalRequest;
    }

    public Exception getOriginException() {
        return originException;
    }

}
