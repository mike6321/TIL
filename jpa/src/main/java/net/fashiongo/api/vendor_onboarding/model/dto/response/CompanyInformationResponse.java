package net.fashiongo.api.vendor_onboarding.model.dto.response;

import lombok.*;
import net.fashiongo.api.vendor_onboarding.model.entity.Address;
import net.fashiongo.api.vendor_onboarding.model.entity.Category;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyInformationResponse extends OnBoardingResponse {

    private Long id;
    private Category category;
    private Address businessAddress;
    private Address showroomAddress;
    private Address billingAddress;
    private String website;
    private String instagram;
    private String additionalCompanyInformation;

}
