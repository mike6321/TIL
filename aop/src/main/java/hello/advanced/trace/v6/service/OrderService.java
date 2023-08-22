package hello.advanced.trace.v6.service;

import hello.advanced.trace.v6.domain.Orders;
import hello.advanced.trace.v6.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Orders create() {
        return orderRepository.save(Orders.of());
    }

}
