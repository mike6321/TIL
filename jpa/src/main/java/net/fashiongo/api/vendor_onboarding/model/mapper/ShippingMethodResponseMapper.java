package net.fashiongo.api.vendor_onboarding.model.mapper;

import lombok.Getter;
import net.fashiongo.api.vendor_onboarding.model.dto.response.ShippingMethodResponse;
import net.fashiongo.api.vendor_onboarding.model.dto.response.ShippingMethodResponseDto;
import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShippingMethodResponseMapper {

    public static ShippingMethodResponse of(OnBoardingAccount onBoardingAccountEntity) {
        List<ShippingMethodResponseDto> shippingMethodResponseDtoList = convertShippingMethodResponseDto(onBoardingAccountEntity);
        return ShippingMethodResponse.builder()
                .id(onBoardingAccountEntity.getId())
                .shippingMethodResponseDto(shippingMethodResponseDtoList)
                .build();
    }

    public static List<ShippingMethodResponseDto> convertShippingMethodResponseDto(OnBoardingAccount onBoardingAccountEntity) {
        return onBoardingAccountEntity.getShippingMethods()
                .stream()
                .map(shippingMethodEntity -> ShippingMethodResponseDto.builder()
                        .courier(shippingMethodEntity.getCourier())
                        .shipMethod(shippingMethodEntity.getShipMethod())
                        .isDefault(shippingMethodEntity.isDefault())
                        .build())
                .collect(Collectors.toList());
    }

}
