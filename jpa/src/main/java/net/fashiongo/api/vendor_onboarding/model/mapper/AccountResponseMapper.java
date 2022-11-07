package net.fashiongo.api.vendor_onboarding.model.mapper;

import net.fashiongo.api.vendor_onboarding.model.dto.response.AccountResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;

public class AccountResponseMapper {

    public static AccountResponse of(OnBoardingAccount onBoardingAccountEntity) {
        return AccountResponse.builder()
                .id(onBoardingAccountEntity.getId())
                .firstName(onBoardingAccountEntity.getFirstName())
                .emailAddress(onBoardingAccountEntity.getEmailAddress())
                .userId(onBoardingAccountEntity.getUserId())
                .password(onBoardingAccountEntity.getPassword())
                .companyName(onBoardingAccountEntity.getCompanyName())
                .build();
    }

}
