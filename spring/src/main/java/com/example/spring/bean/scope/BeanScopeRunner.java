package com.example.spring.bean.scope;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class BeanScopeRunner implements ApplicationRunner {

    private final ApplicationContext applicationContext;

    /**
     * Singleton Scope
     * 2024-03-12 10:08:40.213  INFO 17246 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Single@64021427
     * 2024-03-12 10:08:40.213  INFO 17246 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Single@64021427
     * 2024-03-12 10:08:40.213  INFO 17246 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Single@64021427
     *
     * Prototype Scope
     * 2024-03-12 10:08:40.212  INFO 17246 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@7e3ee128
     * 2024-03-12 10:08:40.212  INFO 17246 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@7d64a960
     * 2024-03-12 10:08:40.212  INFO 17246 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@166ce247
     *
     * Singleton 내부의 Prototype
     * 2024-03-12 10:10:21.838  INFO 17380 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@cdbe995
     * 2024-03-12 10:10:21.838  INFO 17380 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@cdbe995
     * 2024-03-12 10:10:21.838  INFO 17380 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@cdbe995
     *
     * Singleton 내부의 Prototype (proxyMode = ScopedProxyMode.TARGET_CLASS)
     * 2024-03-12 10:11:45.722  INFO 17490 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@595814a1
     * 2024-03-12 10:11:45.722  INFO 17490 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@7de5871d
     * 2024-03-12 10:11:45.722  INFO 17490 --- [           main] c.e.spring.bean.scope.BeanScopeRunner    : com.example.spring.bean.scope.Proto@49d42faf
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("************ prototype ************");
        log.info("{} ", applicationContext.getBean(Proto.class));
        log.info("{} ", applicationContext.getBean(Proto.class));
        log.info("{} ", applicationContext.getBean(Proto.class));
        log.info("************ prototype ************");

        log.info("************ singleton ************");
        log.info("{} ", applicationContext.getBean(Single.class));
        log.info("{} ", applicationContext.getBean(Single.class));
        log.info("{} ", applicationContext.getBean(Single.class));
        log.info("************ singleton ************");

        log.info("************ singleton.prototype ************");
        Single bean = applicationContext.getBean(Single.class);
        log.info("{}", bean.getProto());
        log.info("{}", bean.getProto());
        log.info("{}", bean.getProto());
        log.info("************ singleton.prototype ************");
    }

}
