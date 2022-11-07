package net.fashiongo.api.vendor_onboarding.repository;

import net.fashiongo.api.vendor_onboarding.model.entity.OnBoardingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OnBoardingAccountRepository extends JpaRepository<OnBoardingAccount, Long> {

    @Transactional(readOnly = true)
    @Query("select o from OnBoardingAccount o " +
            "left join fetch o.companyInformation " +
            "left join fetch o.banner " +
            "left join fetch o.returnCancellationPolicy " +
            "left join fetch o.shippingMethods " +
            "left join fetch o.businessDocuments where o.id = :id")
    OnBoardingAccount findFetchJoinById(Long id);

    @Transactional(readOnly = true)
    List<OnBoardingAccount> findByUserIdOrderByIdDesc(String userId);

}
