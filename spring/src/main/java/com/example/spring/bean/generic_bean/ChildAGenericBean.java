package com.example.spring.bean.generic_bean;

import com.example.spring.bean.generic_bean.dto.Parent;
import org.springframework.stereotype.Component;

/*
* 타입에 자식 타입을 작성하면 오류
* (Child -> Parent)
* */
@Component
public class ChildAGenericBean implements GenericBean<Parent> {
//public class ChildAGenericBean implements GenericBean<ChildA> {

    @Override
    public void method(Parent request) {
        System.out.println("ChildAGenericBean");
    }

}
