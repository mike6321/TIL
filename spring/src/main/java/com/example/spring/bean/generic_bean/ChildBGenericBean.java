package com.example.spring.bean.generic_bean;

import com.example.spring.bean.generic_bean.dto.Parent;
import org.springframework.stereotype.Component;

@Component
public class ChildBGenericBean implements GenericBean<Parent> {
//public class ChildBGenericBean implements GenericBean<ChildB> {

    @Override
    public void method(Parent request) {
        System.out.println("ChildBGenericBean");
    }

}
