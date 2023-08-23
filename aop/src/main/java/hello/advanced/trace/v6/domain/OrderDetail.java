package hello.advanced.trace.v6.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "orders_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDetailId;

    private OrderStatus status;

    public static OrderDetail of() {
        return OrderDetail.builder()
                .status(OrderStatus.CONFIRMED)
                .build();
    }

}
