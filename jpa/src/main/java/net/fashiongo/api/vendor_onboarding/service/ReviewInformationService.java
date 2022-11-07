package net.fashiongo.api.vendor_onboarding.service;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.vendor_onboarding.model.dto.response.ReviewInformationResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.model.mapper.ReviewInformationResponseMapper;
import net.fashiongo.api.vendor_onboarding.repository.OnBoardingAccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewInformationService {

    private final OnBoardingAccountRepository onBoardingAccountRepository;

//    @Transactional(readOnly = true)
    public ReviewInformationResponse getReviewInformation(Long onBoardingId) {
//        OnBoardingAccount onBoardingAccountEntity = onBoardingAccountRepository.findFetchJoinById(onBoardingId);
        OnBoardingAccount onBoardingAccountEntity = onBoardingAccountRepository.findById(onBoardingId)
                .orElseThrow();
//        CompanyInformation companyInformation = onBoardingAccountEntity.getCompanyInformation();

        return ReviewInformationResponseMapper.of(onBoardingAccountEntity);
    }

}
