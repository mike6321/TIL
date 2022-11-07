package net.fashiongo.api.vendor_onboarding.model.dto.response;

import lombok.*;
import net.fashiongo.api.vendor_onboarding.model.entity.Banner;
import net.fashiongo.api.vendor_onboarding.model.entity.BusinessDocument;

import java.util.Set;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewInformationResponse extends OnBoardingResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userId;
    private String password;
    private String companyName;
    private CompanyInformationResponse companyInformation;
    private Banner banner;
    private ReturnCancellationPolicyResponse returnCancellationPolicy;
    private ShippingMethodResponse shippingMethods;
    private Set<BusinessDocument> businessDocuments;

}
