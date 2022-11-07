package net.fashiongo.api.vendor_onboarding.model.dto.request;

import lombok.Getter;

@Getter
public class ShippingMethodRequestDto {

    private String courier;
    private boolean isDefault;
    private String shipMethod;

}
