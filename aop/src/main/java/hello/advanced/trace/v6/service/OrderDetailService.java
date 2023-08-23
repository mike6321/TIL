package hello.advanced.trace.v6.service;

import hello.advanced.trace.v6.domain.OrderDetail;
import hello.advanced.trace.v6.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateOrderDetailStatus() throws RuntimeException {
        orderDetailRepository.save(OrderDetail.of());
        throw new RuntimeException();
    }

}
