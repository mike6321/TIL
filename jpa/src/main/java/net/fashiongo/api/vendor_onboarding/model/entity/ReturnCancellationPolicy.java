package net.fashiongo.api.vendor_onboarding.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.fashiongo.api.common.model.AuditEntity;
import net.fashiongo.api.vendor_onboarding.model.dto.request.ReturnCancellationPolicyRequest;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "return_cancellation_policy")
public class ReturnCancellationPolicy extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_cancellation_policy_id")
    private Long id;

    @Column(name = "return_policy")
    private String returnPolicy;

    @Column(name = "cancellation_policy")
    private String cancellationPolicy;

    public static ReturnCancellationPolicy of(ReturnCancellationPolicyRequest returnCancellationPolicyRequest) {
        return ReturnCancellationPolicy.builder()
                .returnPolicy(returnCancellationPolicyRequest.getReturnPolicy())
                .cancellationPolicy(returnCancellationPolicyRequest.getCancellationPolicy())
                .build();
    }

}
