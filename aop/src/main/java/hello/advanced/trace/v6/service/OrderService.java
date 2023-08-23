package hello.advanced.trace.v6.service;

import hello.advanced.trace.v6.aspect.UpdateOrderStatus;
import hello.advanced.trace.v6.domain.Orders;
import hello.advanced.trace.v6.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @UpdateOrderStatus
    @Transactional
    public Orders create() {
        return orderRepository.save(Orders.of());
    }

    @Transactional
    public Orders createWithOutCommit() {
        Orders orders = orderRepository.save(Orders.of());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public List<Orders> findAll() throws InterruptedException {
        return orderRepository.findAll();
    }

}
