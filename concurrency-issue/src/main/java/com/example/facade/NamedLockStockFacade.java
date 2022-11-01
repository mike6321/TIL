package com.example.facade;

import com.example.repository.LockRepository;
import com.example.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class NamedLockStockFacade {

    private final LockRepository lockRepository;
    private final StockService stockService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void decrease(Long id, Long quantity) {
        try {
            lockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);
        } finally {
            lockRepository.releaseLock(id.toString());
        }
    }

}
