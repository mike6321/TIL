package hello.advanced.trace.v6.domain;

import javax.persistence.*;

@Entity
@Table(name = "orders_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    private OrderStatus status;

}
