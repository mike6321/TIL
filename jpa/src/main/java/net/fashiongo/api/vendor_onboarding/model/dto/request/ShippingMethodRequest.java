package net.fashiongo.api.vendor_onboarding.model.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class ShippingMethodRequest {

    private Long id;
    private List<ShippingMethodRequestDto> shippingMethods;

}
