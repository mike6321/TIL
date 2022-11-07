package net.fashiongo.api.vendor_onboarding.service;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.vendor_onboarding.model.dto.response.CompanyDescriptionResponse;
import net.fashiongo.api.vendor_onboarding.model.dto.response.OnBoardingResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.model.entity.Step;
import net.fashiongo.api.vendor_onboarding.model.mapper.CompanyInformationResponseMapper;
import net.fashiongo.api.vendor_onboarding.model.mapper.ReturnCancellationPolicyResponseMapper;
import net.fashiongo.api.vendor_onboarding.model.mapper.ReviewInformationResponseMapper;
import net.fashiongo.api.vendor_onboarding.model.mapper.ShippingMethodResponseMapper;
import net.fashiongo.api.vendor_onboarding.repository.OnBoardingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StepStrategyService {

    private final OnBoardingAccountRepository onBoardingAccountRepository;

    @Transactional(readOnly = true)
    public OnBoardingResponse getStepInformation(String userId) {
        return findExecuteStrategyByStep(userId);
    }

    private OnBoardingResponse findExecuteStrategyByStep(String userId) {
        OnBoardingAccount onBoardingAccount = getOnBoardingAccount(userId);
        Step step = onBoardingAccount.getStep();

        switch (step) {
            case STEP02:
                return CompanyInformationResponseMapper.of(onBoardingAccount);
            case STEP03:
            case STEP04:
                return CompanyDescriptionResponse.of(onBoardingAccount);
            case STEP05:
                return ReturnCancellationPolicyResponseMapper.of(onBoardingAccount);
            case STEP06:
                return ShippingMethodResponseMapper.of(onBoardingAccount);
            case STEP07:
            case STEP08:
            case STEP09:
                return ReviewInformationResponseMapper.of(onBoardingAccount);
            default:
                throw new IllegalArgumentException("STEP cannot be null.");
        }
    }

    private OnBoardingAccount getOnBoardingAccount(String userId) {
        return onBoardingAccountRepository.findByUserIdOrderByIdDesc(userId)
                .get(0);
    }

}
