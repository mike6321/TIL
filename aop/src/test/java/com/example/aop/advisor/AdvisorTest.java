package com.example.aop.advisor;

import com.example.aop.common.advice.TimeAdvice;
import com.example.aop.common.service.ServiceImpl;
import com.example.aop.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

@Slf4j
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

    @Test
    @DisplayName("직접 만든 포인트컷")
    void advisorTest02() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new MyPointcut(), new TimeAdvice());
        proxyFactory.addAdvisor(advisor);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
        /**
         * 22:35:50.175 [main] INFO com.example.aop.advisor.AdvisorTest - 포인트컷 호출 method=save targetClass=class com.example.aop.common.service.ServiceImpl
         * 22:35:50.178 [main] INFO com.example.aop.advisor.AdvisorTest - 포인트컷 결과 result=true
         * 22:35:50.182 [main] INFO com.example.aop.common.advice.TimeAdvice - TimeProxy 실행
         * 22:35:50.182 [main] INFO com.example.aop.common.service.ServiceImpl - save 호출
         * 22:35:50.182 [main] INFO com.example.aop.common.advice.TimeAdvice - TimeProxy 종료 resultTime = 0
         * 22:35:50.182 [main] INFO com.example.aop.advisor.AdvisorTest - 포인트컷 호출 method=find targetClass=class com.example.aop.common.service.ServiceImpl
         * 22:35:50.182 [main] INFO com.example.aop.advisor.AdvisorTest - 포인트컷 결과 result=false
         * 22:35:50.183 [main] INFO com.example.aop.common.service.ServiceImpl - find 호출
         * */
    }

    @Test
    @DisplayName("스프링이 제공하는 포인트컷")
    void advisorTest03() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
        nameMatchMethodPointcut.setMappedName("find");

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(nameMatchMethodPointcut, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.save();
        proxy.find();
    }

    static class MyPointcut implements Pointcut {

        @Override
        public ClassFilter getClassFilter() {
            return ClassFilter.TRUE;
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return new MyMethodMatcher();
        }

    }

    static class MyMethodMatcher implements MethodMatcher {

        private final static String MATCH_NAME = "save";

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            boolean result = method.getName().equals(MATCH_NAME);
            log.info("포인트컷 호출 method={} targetClass={}", method.getName(), targetClass);
            log.info("포인트컷 결과 result={}", result);
            return result;
        }

        @Override
        public boolean isRuntime() {
            return false;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            throw new UnsupportedOperationException();
        }

    }

}
