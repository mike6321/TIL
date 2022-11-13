package com.example.aop.proxyfactory;

import com.example.aop.common.advice.TimeAdvice;
import com.example.aop.common.service.ConcreteService;
import com.example.aop.common.service.ServiceImpl;
import com.example.aop.common.service.ServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.aop.support.AopUtils.*;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    void interfaceProxy() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        /**
         * 21:53:12.968 [main] INFO com.example.aop.proxyfactory.ProxyFactoryTest - targetClass=class com.example.aop.common.service.ServiceImpl
         * 21:53:12.972 [main] INFO com.example.aop.proxyfactory.ProxyFactoryTest - proxyClass=class com.sun.proxy.$Proxy10
         * */
        assertThat(isAopProxy(proxy)).isTrue();
        assertThat(isJdkDynamicProxy(proxy)).isTrue();
        assertThat(isCglibProxy(proxy)).isFalse();
    }

    @Test
    @DisplayName("구체 클래스가 있으면 cglib 사용")
    void concreteClassProxy() {
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.call();

        /**
         * 22:01:00.889 [main] INFO com.example.aop.proxyfactory.ProxyFactoryTest - targetClass=class com.example.aop.common.service.ConcreteService
         * 22:01:00.892 [main] INFO com.example.aop.proxyfactory.ProxyFactoryTest - proxyClass=class com.example.aop.common.service.ConcreteService$$EnhancerBySpringCGLIB$$f17ec5e6
         * */
        assertThat(isAopProxy(proxy)).isTrue();
        assertThat(isJdkDynamicProxy(proxy)).isFalse();
        assertThat(isCglibProxy(proxy)).isTrue();
    }

    @Test
    @DisplayName("ProxyTargetClass 옵션을 사용하면 인터페이스가 있어도 cglib 을 사용")
    void proxyTargetClass() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

        /**
         * 22:06:02.071 [main] INFO com.example.aop.proxyfactory.ProxyFactoryTest - targetClass=class com.example.aop.common.service.ServiceImpl
         * 22:06:02.076 [main] INFO com.example.aop.proxyfactory.ProxyFactoryTest - proxyClass=class com.example.aop.common.service.ServiceImpl$$EnhancerBySpringCGLIB$$12c5b76c
         * */
        assertThat(isAopProxy(proxy)).isTrue();
        assertThat(isJdkDynamicProxy(proxy)).isFalse();
        assertThat(isCglibProxy(proxy)).isTrue();
    }

}
