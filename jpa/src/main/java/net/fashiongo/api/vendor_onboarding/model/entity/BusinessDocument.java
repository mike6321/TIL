package net.fashiongo.api.vendor_onboarding.model.entity;

import net.fashiongo.api.common.model.AuditEntity;

import javax.persistence.*;

@Entity
@Table(name = "business_document")
public class BusinessDocument extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_document_id")
    private Long id;

    @Column(name = "document_type")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "document_url")
    private String documentUrl;

    @Column(name = "is_active")
    private boolean isActive;

}
