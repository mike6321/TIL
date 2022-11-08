package com.example.jpa.service;

import com.example.jpa.entity.Menu;
import com.example.jpa.entity.Restaurant;
import com.example.jpa.model.dto.response.ReviewResponse;
import com.example.jpa.model.mapper.ReviewResponseMapper;
import com.example.jpa.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {

    private final RestaurantRepository restaurantRepository;
    private final EntityManagerFactory entityManagerFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public ReviewResponse getReview(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow();
        boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        log.info("transaction active = {}", transactionActive);
        boolean currentTransactionReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        log.info("transaction readOnly = {}", currentTransactionReadOnly);

        Session session = entityManager.unwrap(Session.class);
        boolean open = session.isOpen();
//        Filter openSessionInViewInterceptor = session.enableFilter("OpenSessionInViewInterceptor");
//        System.out.println("open = " + open);

        PersistenceUnitUtil persistenceUnitUtil = this.entityManagerFactory.getPersistenceUnitUtil();
        boolean isLoadedRestaurantMoreInformation = persistenceUnitUtil.isLoaded(restaurant.getRestaurantMoreInformation());
        System.out.println("isLoadedRestaurantMoreInformation = " + isLoadedRestaurantMoreInformation);
        Set<Menu> menus = restaurant.getMenus();
        boolean isLoadedMenus = persistenceUnitUtil.isLoaded(restaurant.getMenus());
        System.out.println("isLoadedMenus = " + isLoadedMenus);

        return ReviewResponseMapper.of(restaurant);
    }

}
