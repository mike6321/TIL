package com.example.spring.bean.scope;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Single {

    private final Proto proto;

    public Proto getProto() {
        return proto;
    }

}
