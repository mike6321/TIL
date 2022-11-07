package net.fashiongo.api.vendor_onboarding.model.dto.response;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShippingMethodResponseDto {

    private String courier;
    private boolean isDefault;
    private String shipMethod;

}
