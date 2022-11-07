package net.fashiongo.api.vendor_onboarding.model.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String country;
    private String address1;
    private String address2;
    private String zipCode;
    private String city;
    private String state;
    private String phoneNumber;

}
