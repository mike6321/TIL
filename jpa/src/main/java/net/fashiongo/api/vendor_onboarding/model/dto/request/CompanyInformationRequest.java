package net.fashiongo.api.vendor_onboarding.model.dto.request;

import lombok.Getter;
import net.fashiongo.api.vendor_onboarding.model.entity.Address;
import net.fashiongo.api.vendor_onboarding.model.entity.Category;

@Getter
public class CompanyInformationRequest {

    private Long id;
    private Category category;
    private Address businessAddress;
    private Address showroomAddress;
    private Address billingAddress;
    private String website;
    private String instagram;
    private String additionalCompanyInformation;
    private String companyDescription;

}
