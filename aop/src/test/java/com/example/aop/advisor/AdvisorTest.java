package com.example.aop.advisor;

import com.example.aop.common.advice.TimeAdvice;
import com.example.aop.common.service.ServiceImpl;
import com.example.aop.common.service.ServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AdvisorTest {

    @Test
    void advisorTest01() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
        /**
         * 22:18:19.370 [main] INFO com.example.aop.common.advice.TimeAdvice - TimeProxy 실행
         * 22:18:19.373 [main] INFO com.example.aop.common.service.ServiceImpl - save 호출
         * 22:18:19.373 [main] INFO com.example.aop.common.advice.TimeAdvice - TimeProxy 종료 resultTime = 0
         * 22:18:19.375 [main] INFO com.example.aop.common.advice.TimeAdvice - TimeProxy 실행
         * 22:18:19.375 [main] INFO com.example.aop.common.service.ServiceImpl - find 호출
         * 22:18:19.375 [main] INFO com.example.aop.common.advice.TimeAdvice - TimeProxy 종료 resultTime = 0
         * */
    }

}
