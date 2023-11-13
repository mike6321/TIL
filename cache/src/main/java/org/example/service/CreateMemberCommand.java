package org.example.service;

import org.springframework.util.Assert;

public record CreateMemberCommand(String userCode, String password) {

    public CreateMemberCommand{
        Assert.hasLength(userCode, "userCode can't be empty");
        Assert.hasLength(password, "password can't be empty");
    }

}
