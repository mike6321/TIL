package net.fashiongo.api.vendor_onboarding.service;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.vendor_onboarding.model.dto.request.ReturnCancellationPolicyRequest;
import net.fashiongo.api.vendor_onboarding.model.dto.response.ReturnCancellationPolicyResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.model.entity.ReturnCancellationPolicy;
import net.fashiongo.api.vendor_onboarding.model.mapper.ReturnCancellationPolicyResponseMapper;
import net.fashiongo.api.vendor_onboarding.repository.OnBoardingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReturnCancellationPolicyService {

    private final OnBoardingAccountRepository onBoardingAccountRepository;

    @Transactional
    public ReturnCancellationPolicyResponse createReturnCancellationPolicy(ReturnCancellationPolicyRequest returnCancellationPolicyRequest) {
        OnBoardingAccount onBoardingAccount = onBoardingAccountRepository.findById(returnCancellationPolicyRequest.getId())
                .orElseThrow();

        onBoardingAccount.createReturnCancellationPolicy(ReturnCancellationPolicy.of(returnCancellationPolicyRequest));

        return ReturnCancellationPolicyResponseMapper.of(onBoardingAccount);
    }

}
