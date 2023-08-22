package hello.advanced.trace.v6.repository;

import hello.advanced.trace.v6.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
