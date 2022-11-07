package net.fashiongo.api.vendor_onboarding.service;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.vendor_onboarding.model.dto.request.ShippingMethodRequest;
import net.fashiongo.api.vendor_onboarding.model.dto.response.ShippingMethodResponse;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import net.fashiongo.api.vendor_onboarding.model.entity.ShippingMethod;
import net.fashiongo.api.vendor_onboarding.model.mapper.ShippingMethodResponseMapper;
import net.fashiongo.api.vendor_onboarding.repository.OnBoardingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShippingMethodService {

    private final OnBoardingAccountRepository onBoardingAccountRepository;

    @Transactional
    public ShippingMethodResponse createShippingMethod(ShippingMethodRequest shippingMethodRequest) {
        OnBoardingAccount onBoardingAccount = onBoardingAccountRepository.findById(shippingMethodRequest.getId())
                .orElseThrow();

        Set<ShippingMethod> shippingMethods = shippingMethodRequest.getShippingMethods()
                .stream()
                .map(ShippingMethod::of)
                .collect(Collectors.toSet());

        onBoardingAccount.createShippingMethod(shippingMethods);

        return ShippingMethodResponseMapper.of(onBoardingAccount);
    }

}
