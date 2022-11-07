package net.fashiongo.api.vendor_onboarding.model.mapper;

import lombok.Getter;
import net.fashiongo.api.vendor_onboarding.model.dto.response.ReturnCancellationPolicyResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.model.entity.ReturnCancellationPolicy;

@Getter
public class ReturnCancellationPolicyResponseMapper {

    public static ReturnCancellationPolicyResponse of(OnBoardingAccount onBoardingAccountEntity) {
        ReturnCancellationPolicy returnCancellationPolicyEntity = onBoardingAccountEntity.getReturnCancellationPolicy();
        return ReturnCancellationPolicyResponse.builder()
                .id(onBoardingAccountEntity.getId())
                .returnPolicy(returnCancellationPolicyEntity.getReturnPolicy())
                .cancellationPolicy(returnCancellationPolicyEntity.getCancellationPolicy())
                .build();
    }

}
