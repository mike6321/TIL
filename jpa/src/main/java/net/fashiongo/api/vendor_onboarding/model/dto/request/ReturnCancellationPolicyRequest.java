package net.fashiongo.api.vendor_onboarding.model.dto.request;

import lombok.Getter;

@Getter
public class ReturnCancellationPolicyRequest {

    private Long id;
    private String returnPolicy;
    private String cancellationPolicy;

}
