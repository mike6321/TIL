package hello.advanced.trace.v6.service;

import hello.advanced.trace.v6.domain.Orders;
import hello.advanced.trace.v6.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
        entityManager.flush();
        entityManager.clear();
    }

    @DisplayName("AOP 트랜잭션 분리 테스트")
    @Test
    @Transactional
    void test01() {
        Orders orders = orderService.create();
        assertThat(orders).isNotNull();
    }

    @DisplayName("트랜잭션 격리수준 테스트 - READ_COMMITTED")
    @Test
    @Transactional(isolation = Isolation.READ_COMMITTED)
    void test02() throws InterruptedException {
        // given
        AtomicReference<List<Orders>> orders = new AtomicReference<>();

        // when
        // 데이터 생성
        Thread thread01 = new Thread(() -> orderService.createWithOutCommit());
        // 데이터 조회
        Thread thread02 = new Thread(() -> {
            try {
                orders.set(orderService.findAll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread01.start();
        Thread.sleep(500);
        thread02.start();

        thread01.join();
        thread02.join();

        // then
        List<Orders> result = orders.get();
        assertThat(result.size()).isNotEqualTo(1);
    }

}
