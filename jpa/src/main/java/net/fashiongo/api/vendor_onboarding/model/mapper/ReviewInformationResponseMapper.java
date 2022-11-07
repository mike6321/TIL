package net.fashiongo.api.vendor_onboarding.model.mapper;

import net.fashiongo.api.vendor_onboarding.model.dto.response.ReviewInformationResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.*;

import java.util.Set;

public class ReviewInformationResponseMapper {

    public static ReviewInformationResponse of(OnBoardingAccount onBoardingAccountEntity) {
        CompanyInformation companyInformation = onBoardingAccountEntity.getCompanyInformation();
        Banner banner = onBoardingAccountEntity.getBanner();
        Set<ShippingMethod> shippingMethods = onBoardingAccountEntity.getShippingMethods();
        ReturnCancellationPolicy returnCancellationPolicy = onBoardingAccountEntity.getReturnCancellationPolicy();
        Set<BusinessDocument> businessDocuments = onBoardingAccountEntity.getBusinessDocuments();

        return ReviewInformationResponse.builder()
                .id(onBoardingAccountEntity.getId())
                .firstName(onBoardingAccountEntity.getFirstName())
                .lastName(onBoardingAccountEntity.getLastName())
                .emailAddress(onBoardingAccountEntity.getEmailAddress())
                .userId(onBoardingAccountEntity.getUserId())
                .password(onBoardingAccountEntity.getPassword())
                .companyName(onBoardingAccountEntity.getCompanyName())
                .companyInformation(companyInformation == null ? null : CompanyInformationResponseMapper.of(onBoardingAccountEntity))
                .banner(banner == null ? null : banner)
                .returnCancellationPolicy(returnCancellationPolicy == null ? null : ReturnCancellationPolicyResponseMapper.of(onBoardingAccountEntity))
                .shippingMethods(shippingMethods == null ? null : ShippingMethodResponseMapper.of(onBoardingAccountEntity))
                .businessDocuments(businessDocuments == null ? null : businessDocuments)
                .build();
    }

}
