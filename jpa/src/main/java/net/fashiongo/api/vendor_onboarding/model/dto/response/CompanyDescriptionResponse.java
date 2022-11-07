package net.fashiongo.api.vendor_onboarding.model.dto.response;

import lombok.*;
import net.fashiongo.api.vendor_onboarding.model.entity.CompanyInformation;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyDescriptionResponse extends OnBoardingResponse {

    private Long id;
    private String companyDescription;

    public static CompanyDescriptionResponse of(OnBoardingAccount onBoardingAccountEntity) {
        CompanyInformation companyInformation = onBoardingAccountEntity.getCompanyInformation();
        return CompanyDescriptionResponse.builder()
                .id(onBoardingAccountEntity.getId())
                .companyDescription(companyInformation.getCompanyDescription())
                .build();
    }

}
