package net.fashiongo.api.vendor_onboarding.model.entity;

import net.fashiongo.api.common.model.AuditEntity;

import javax.persistence.*;

@Entity
@Table(name = "banner")
public class Banner extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banner_id")
    private Long id;

    @Column(name = "banner_type")
    @Enumerated(EnumType.STRING)
    private BannerType bannerType;

    @Column(name = "image_url")
    private String imageUrl;

}
