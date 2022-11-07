package net.fashiongo.api.vendor_onboarding.model.dto.request;

import lombok.Getter;

@Getter
public class AccountRequest {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userId;
    private String password;
    private String companyName;

}
