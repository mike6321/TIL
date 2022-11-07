package net.fashiongo.api.vendor_onboarding.model.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Category {

    @Column(name = "women_apparel")
    private boolean womenApparel;
    @Column(name = "shoes")
    private boolean shoes;
    @Column(name = "accessories")
    private boolean accessories;
    @Column(name = "jewelry")
    private boolean jewelry;
    @Column(name = "bags")
    private boolean bags;
    @Column(name = "beauty")
    private boolean beauty;
    @Column(name = "kids")
    private boolean kids;
    @Column(name = "men")
    private boolean men;
    @Column(name = "home")
    private boolean home;
    @Column(name = "life_style")
    private boolean lifeStyle;
    @Column(name = "retailer_supplies")
    private boolean retailerSupplies;

}
