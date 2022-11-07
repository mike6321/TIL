package net.fashiongo.api.vendor_onboarding.service;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.vendor_onboarding.model.dto.request.AccountRequest;
import net.fashiongo.api.vendor_onboarding.model.dto.response.AccountResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.model.mapper.AccountResponseMapper;
import net.fashiongo.api.vendor_onboarding.repository.OnBoardingAccountRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final OnBoardingAccountRepository onBoardingAccountRepository;

//    @Transactional
    public AccountResponse createAccountService(AccountRequest accountRequest) {
        OnBoardingAccount onBoardingAccountEntity = onBoardingAccountRepository.save(OnBoardingAccount.of(accountRequest));
        return AccountResponseMapper.of(onBoardingAccountEntity);
    }

}
