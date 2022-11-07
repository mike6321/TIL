package net.fashiongo.api.vendor_onboarding.model.entity;

import lombok.*;
import net.fashiongo.api.common.model.AuditEntity;
import net.fashiongo.api.vendor_onboarding.model.dto.request.CompanyInformationRequest;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Table(name = "company_information")
public class CompanyInformation extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_information_id")
    private Long id;

    private Category category;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="country",
                    column=@Column(name="business_country")),
            @AttributeOverride(name="address1",
                    column=@Column(name="business_address1")),
            @AttributeOverride(name="address2",
                    column=@Column(name="business_address2")),
            @AttributeOverride(name="zipCode",
                    column=@Column(name="business_zip_code")),
            @AttributeOverride(name="city",
                    column=@Column(name="business_city")),
            @AttributeOverride(name="state",
                    column=@Column(name="business_state")),
            @AttributeOverride(name="phoneNumber",
                    column=@Column(name="business_phone_number"))
    })
    private Address businessAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="country",
                    column=@Column(name="showroom_country")),
            @AttributeOverride(name="address1",
                    column=@Column(name="showroom_address1")),
            @AttributeOverride(name="address2",
                    column=@Column(name="showroom_address2")),
            @AttributeOverride(name="zipCode",
                    column=@Column(name="showroom_zip_code")),
            @AttributeOverride(name="city",
                    column=@Column(name="showroom_city")),
            @AttributeOverride(name="state",
                    column=@Column(name="showroom_state")),
            @AttributeOverride(name="phoneNumber",
                    column=@Column(name="showroom_phone_number"))
    })
    private Address showroomAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="country",
                    column=@Column(name="billing_country")),
            @AttributeOverride(name="address1",
                    column=@Column(name="billing_address1")),
            @AttributeOverride(name="address2",
                    column=@Column(name="billing_address2")),
            @AttributeOverride(name="zipCode",
                    column=@Column(name="billing_zip_code")),
            @AttributeOverride(name="city",
                    column=@Column(name="billing_city")),
            @AttributeOverride(name="state",
                    column=@Column(name="billing_state")),
            @AttributeOverride(name="phoneNumber",
                    column=@Column(name="billing_phone_number"))
    })
    private Address billingAddress;

    @Column(name = "website")
    private String website;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "additional_company_information")
    private String additionalCompanyInformation;

    @Column(name = "company_description")
    private String companyDescription;

    public static CompanyInformation of(CompanyInformationRequest companyInformationRequest) {
        return CompanyInformation.builder()
                .category(companyInformationRequest.getCategory())
                .businessAddress(companyInformationRequest.getBusinessAddress())
                .showroomAddress(companyInformationRequest.getShowroomAddress())
                .billingAddress(companyInformationRequest.getBillingAddress())
                .website(companyInformationRequest.getWebsite())
                .instagram(companyInformationRequest.getInstagram())
                .additionalCompanyInformation(companyInformationRequest.getAdditionalCompanyInformation())
                .companyDescription(companyInformationRequest.getCompanyDescription())
                .build();
    }

    public void createCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

}
