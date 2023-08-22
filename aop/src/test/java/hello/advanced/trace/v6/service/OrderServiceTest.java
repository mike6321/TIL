package hello.advanced.trace.v6.service;

import hello.advanced.trace.v6.domain.Orders;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    void test() {
        Orders orders = orderService.create();
        assertThat(orders).isNotNull();
    }

}
