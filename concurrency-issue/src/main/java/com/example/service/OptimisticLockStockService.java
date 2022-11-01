package com.example.service;

import com.example.domain.Stock;
import com.example.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OptimisticLockStockService {

    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByWithOptimisticLock(id);

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }

}
