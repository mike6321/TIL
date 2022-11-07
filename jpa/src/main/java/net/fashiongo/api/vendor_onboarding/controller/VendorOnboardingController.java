package net.fashiongo.api.vendor_onboarding.controller;

import lombok.RequiredArgsConstructor;
import net.fashiongo.api.common.model.command.ApiResponse;
import net.fashiongo.api.common.model.command.ApiResponseHeader;
import net.fashiongo.api.common.model.command.ResultCode;
import net.fashiongo.api.common.model.command.SingleObject;
import net.fashiongo.api.vendor_onboarding.model.dto.request.*;
import net.fashiongo.api.vendor_onboarding.model.dto.response.*;
import net.fashiongo.api.vendor_onboarding.service.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/1.0/onboarding/")
public class VendorOnboardingController {

    private final ReviewInformationService reviewInformationService;
    private final AccountService accountService;
    private final CompanyInformationService companyInformationService;
    private final CompanyDescriptionService companyDescriptionService;
    private final ReturnCancellationPolicyService returnCancellationPolicyService;
    private final ShippingMethodService shippingMethodService;
    private final StepStrategyService stepStrategyService;

    @GetMapping("review-information/{onBoardingId}")
    public ApiResponse getReviewInformation(@PathVariable Long onBoardingId) {
        ReviewInformationResponse reviewInformationResponse = reviewInformationService.getReviewInformation(onBoardingId);
        return new ApiResponse(ApiResponseHeader.create(ResultCode.SUCCESS), new SingleObject<>(reviewInformationResponse));
    }

    @PostMapping("account")
    public ApiResponse createAccount(@RequestBody AccountRequest accountRequest) {
        AccountResponse accountResponse = accountService.createAccountService(accountRequest);
        return new ApiResponse(ApiResponseHeader.create(ResultCode.SUCCESS), new SingleObject<>(accountResponse));
    }

    @PostMapping("company-information")
    public ApiResponse createCompanyInformation(@RequestBody CompanyInformationRequest companyInformationRequest) {
        CompanyInformationResponse companyInformationResponse = companyInformationService.createCompanyInformation(
                companyInformationRequest
        );
        return new ApiResponse(ApiResponseHeader.create(ResultCode.SUCCESS), new SingleObject<>(companyInformationResponse));
    }

    @PutMapping("company-description")
    public ApiResponse createCompanyDescription(@RequestBody CompanyDescriptionRequest companyDescriptionRequest) {
        CompanyDescriptionResponse companyDescriptionResponse = companyDescriptionService.createCompanyDescription(
                companyDescriptionRequest
        );
        return new ApiResponse(ApiResponseHeader.create(ResultCode.SUCCESS), new SingleObject<>(companyDescriptionResponse));
    }

    @PostMapping("return-cancellation-policy")
    public ApiResponse createReturnCancellationPolicy(@RequestBody ReturnCancellationPolicyRequest returnCancellationPolicyRequest) {
        ReturnCancellationPolicyResponse returnCancellationPolicyResponse = returnCancellationPolicyService.createReturnCancellationPolicy(
                returnCancellationPolicyRequest
        );
        return new ApiResponse(ApiResponseHeader.create(ResultCode.SUCCESS), new SingleObject<>(returnCancellationPolicyResponse));
    }

    @PostMapping("shipping-method")
    public ApiResponse createShippingMethod(@RequestBody ShippingMethodRequest shippingMethodRequest) {
        ShippingMethodResponse shippingMethodResponse = shippingMethodService.createShippingMethod(shippingMethodRequest);
        return new ApiResponse(ApiResponseHeader.create(ResultCode.SUCCESS), new SingleObject<>(shippingMethodResponse));
    }

    @GetMapping("step")
    public ApiResponse getStepInformation(@RequestParam String userId) {
        OnBoardingResponse stepInformation = stepStrategyService.getStepInformation(userId);
        return new ApiResponse(ApiResponseHeader.create(ResultCode.SUCCESS), new SingleObject<>(stepInformation));
    }

}
