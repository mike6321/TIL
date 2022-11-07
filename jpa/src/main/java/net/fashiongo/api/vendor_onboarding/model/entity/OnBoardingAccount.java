package net.fashiongo.api.vendor_onboarding.model.entity;

import lombok.*;
import net.fashiongo.api.common.model.AuditEntity;
import net.fashiongo.api.vendor_onboarding.model.dto.request.AccountRequest;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Table(name = "on_boarding_account")
public class OnBoardingAccount extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "on_boarding_account_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Enumerated(EnumType.STRING)
    @Column(name = "step")
    private Step step;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "company_information_id")
    private CompanyInformation companyInformation;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "banner_id")
    private Banner banner;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "return_cancellation_policy_id")
    private ReturnCancellationPolicy returnCancellationPolicy;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "on_boarding_account_id")
    private Set<ShippingMethod> shippingMethods;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "on_boarding_account_id")
    private Set<BusinessDocument> businessDocuments;

    public static OnBoardingAccount of(AccountRequest accountRequest) {
        return OnBoardingAccount.builder()
                .firstName(accountRequest.getFirstName())
                .lastName(accountRequest.getLastName())
                .emailAddress(accountRequest.getEmailAddress())
                .userId(accountRequest.getUserId())
                .password(accountRequest.getPassword())
                .companyName(accountRequest.getCompanyName())
                .isCompleted(Boolean.FALSE)
                .step(Step.STEP02)
                .build();
    }

    public void createCompanyInformation(CompanyInformation companyInformation) {
        this.companyInformation = companyInformation;
    }

    public void createReturnCancellationPolicy(ReturnCancellationPolicy returnCancellationPolicy) {
        this.returnCancellationPolicy = returnCancellationPolicy;
    }

    public void createShippingMethod(Set<ShippingMethod> shippingMethods) {
        this.shippingMethods.addAll(Collections.unmodifiableSet(shippingMethods));
    }

    public void validate() {
        if (this.companyInformation == null) {
            throw new IllegalArgumentException("company information does not exist.");
        }
    }

}
