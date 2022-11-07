package net.fashiongo.api.vendor_onboarding.repository;

import net.fashiongo.api.vendor_onboarding.model.entity.CompanyInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInformationRepository extends JpaRepository<CompanyInformation, Long> {
}
