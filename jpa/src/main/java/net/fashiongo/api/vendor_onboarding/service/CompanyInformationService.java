package net.fashiongo.api.vendor_onboarding.service;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.vendor_onboarding.model.dto.request.CompanyInformationRequest;
import net.fashiongo.api.vendor_onboarding.model.dto.response.CompanyInformationResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.CompanyInformation;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.model.mapper.CompanyInformationResponseMapper;
import net.fashiongo.api.vendor_onboarding.repository.OnBoardingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompanyInformationService {

    private final OnBoardingAccountRepository onBoardingAccountRepository;

    @Transactional
    public CompanyInformationResponse createCompanyInformation(CompanyInformationRequest companyInformationRequest) {
        OnBoardingAccount onBoardingAccount = onBoardingAccountRepository.findById(companyInformationRequest.getId())
                .orElseThrow();

        onBoardingAccount.createCompanyInformation(CompanyInformation.of(companyInformationRequest));

        return CompanyInformationResponseMapper.of(onBoardingAccount);
    }

}
