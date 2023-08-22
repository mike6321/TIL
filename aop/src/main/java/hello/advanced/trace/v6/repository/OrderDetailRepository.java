package hello.advanced.trace.v6.repository;

import hello.advanced.trace.v6.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
