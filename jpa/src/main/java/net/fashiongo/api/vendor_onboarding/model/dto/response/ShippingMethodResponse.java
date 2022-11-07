package net.fashiongo.api.vendor_onboarding.model.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShippingMethodResponse extends OnBoardingResponse {

    private Long id;
    private List<ShippingMethodResponseDto> shippingMethodResponseDto;

}
