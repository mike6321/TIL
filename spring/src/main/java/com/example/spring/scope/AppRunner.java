package com.example.spring.scope;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("scopeAppRunner")
@RequiredArgsConstructor
@Slf4j
public class AppRunner implements ApplicationRunner {

    private final Single single;
    private final Proto proto;
    private final ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) {
        log.info(proto.toString());
        log.info(single.getProto().toString());
        log.info(single.toString());
        log.info("Proto");
        log.info(applicationContext.getBean(Proto.class).toString());
        log.info(applicationContext.getBean(Proto.class).toString());
        log.info(applicationContext.getBean(Proto.class).toString());
        log.info("Single");
        log.info(applicationContext.getBean(Single.class).toString());
        log.info(applicationContext.getBean(Single.class).toString());
        log.info(applicationContext.getBean(Single.class).toString());
        log.info("proto by single");
        log.info(applicationContext.getBean(Single.class).getProto().toString());
        log.info(applicationContext.getBean(Single.class).getProto().toString());
        log.info(applicationContext.getBean(Single.class).getProto().toString());
    }

}
