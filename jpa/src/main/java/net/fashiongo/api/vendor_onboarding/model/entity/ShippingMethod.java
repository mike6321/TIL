package net.fashiongo.api.vendor_onboarding.model.entity;

import lombok.*;
import net.fashiongo.api.vendor_onboarding.model.dto.request.ShippingMethodRequestDto;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "shipping_method")
public class ShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipping_method_id")
    private Long id;

    @Column(name = "courier")
    private String courier;

    @Column(name = "ship_method")
    private String shipMethod;

    @Column(name = "is_default")
    private boolean isDefault;

    @Column(name = "is_active")
    private boolean isActive;

    public static ShippingMethod of(ShippingMethodRequestDto shippingMethod) {
        return ShippingMethod.builder()
                .courier(shippingMethod.getCourier())
                .shipMethod(shippingMethod.getShipMethod())
                .isDefault(shippingMethod.isDefault())
                .build();
    }

}
