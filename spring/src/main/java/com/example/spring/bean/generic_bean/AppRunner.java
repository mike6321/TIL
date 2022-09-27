package com.example.spring.bean.generic_bean;

import com.example.spring.bean.generic_bean.dto.ChildA;
import com.example.spring.bean.generic_bean.dto.ChildB;
import com.example.spring.bean.generic_bean.dto.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component("genericAppRunner")
@RequiredArgsConstructor
public class AppRunner implements ApplicationRunner {

    private final GenericExecutorFactory genericExecutorFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ChildA childA = new ChildA(1L, "option1");
        GenericBean<Parent> executeStrategy1 = genericExecutorFactory.findExecuteStrategy(true);
        executeStrategy1.method(childA);

        ChildB childB = new ChildB(1L, "option1");
        GenericBean<Parent> executeStrategy2 = genericExecutorFactory.findExecuteStrategy(false);
        executeStrategy2.method(childB);
    }

}
