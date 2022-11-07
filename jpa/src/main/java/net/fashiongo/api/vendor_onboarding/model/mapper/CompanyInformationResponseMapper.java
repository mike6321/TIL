package net.fashiongo.api.vendor_onboarding.model.mapper;

import net.fashiongo.api.vendor_onboarding.model.dto.response.CompanyInformationResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.CompanyInformation;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;

public class CompanyInformationResponseMapper {

    public static CompanyInformationResponse of(OnBoardingAccount onBoardingAccountEntity) {
        CompanyInformation companyInformationEntity = onBoardingAccountEntity.getCompanyInformation();
        return CompanyInformationResponse.builder()
                .id(onBoardingAccountEntity.getId())
                .category(companyInformationEntity.getCategory())
                .businessAddress(companyInformationEntity.getBusinessAddress())
                .showroomAddress(companyInformationEntity.getShowroomAddress())
                .billingAddress(companyInformationEntity.getBillingAddress())
                .website(companyInformationEntity.getWebsite())
                .instagram(companyInformationEntity.getInstagram())
                .additionalCompanyInformation(companyInformationEntity.getAdditionalCompanyInformation())
                .build();
    }

}
