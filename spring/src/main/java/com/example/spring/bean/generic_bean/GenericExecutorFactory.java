package com.example.spring.bean.generic_bean;

import com.example.spring.bean.generic_bean.dto.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenericExecutorFactory {

    private final GenericBean<Parent> childAGenericBean;
    private final GenericBean<Parent> childBGenericBean;

    public GenericBean<Parent> findExecuteStrategy(boolean check) {
        return check ? childAGenericBean : childBGenericBean;
    }

}
