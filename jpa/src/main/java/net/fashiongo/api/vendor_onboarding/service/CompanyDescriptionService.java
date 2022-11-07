package net.fashiongo.api.vendor_onboarding.service;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.vendor_onboarding.model.dto.request.CompanyDescriptionRequest;
import net.fashiongo.api.vendor_onboarding.model.dto.response.CompanyDescriptionResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.CompanyInformation;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.repository.OnBoardingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyDescriptionService {

    private final OnBoardingAccountRepository onBoardingAccountRepository;

    @Transactional
    public CompanyDescriptionResponse createCompanyDescription(CompanyDescriptionRequest companyDescriptionRequest) {
        OnBoardingAccount onBoardingAccount = onBoardingAccountRepository.findById(companyDescriptionRequest.getId())
                .orElseThrow();

        onBoardingAccount.validate();

        CompanyInformation companyInformation = onBoardingAccount.getCompanyInformation();
        companyInformation.createCompanyDescription(companyDescriptionRequest.getCompanyDescription());

        return CompanyDescriptionResponse.of(onBoardingAccount);
    }
    
}
