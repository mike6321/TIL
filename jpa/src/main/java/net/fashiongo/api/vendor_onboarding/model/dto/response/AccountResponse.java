package net.fashiongo.api.vendor_onboarding.model.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userId;
    private String password;
    private String companyName;

}
