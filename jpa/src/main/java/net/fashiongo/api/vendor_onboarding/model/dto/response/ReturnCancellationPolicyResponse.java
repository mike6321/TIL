package net.fashiongo.api.vendor_onboarding.model.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReturnCancellationPolicyResponse extends OnBoardingResponse {

    private Long id;
    private String returnPolicy;
    private String cancellationPolicy;

}
