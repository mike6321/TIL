package hello.advanced.trace.v6.aspect;

import hello.advanced.trace.v6.domain.Orders;
import hello.advanced.trace.v6.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Aspect
@RequiredArgsConstructor
@Component
public class StatusAspect {

    private final OrderDetailService orderDetailService;

    @Around("@annotation(hello.advanced.trace.v6.aspect.UpdateOrderStatus)")
    public Object orderStatusPerf(final ProceedingJoinPoint joinPoint) throws Throwable {
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("currentTransactionName : {}", currentTransactionName);
        Orders returnValue = (Orders) joinPoint.proceed();
        try {
            orderDetailService.updateOrderDetailStatus();
        } catch (RuntimeException e) {
            log.error("error");
        }

        return returnValue;
    }

}
