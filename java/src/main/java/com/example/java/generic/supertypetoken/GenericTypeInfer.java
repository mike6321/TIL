package com.example.java.generic.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeInfer {

    static class Super<T> {
        T value;
    }

    static class Sub extends Super<String> {
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Super<String> stringSuper = new Super<>();
        Class<?> value = stringSuper.getClass().getDeclaredField("value").getType();
        System.out.println(value); // compile 기법인 eraser 때문에 Object 가 나온다.

        // 상속 받은 클래스인 경우 부모클래스의 제네릭 타입을 알아낼 수 있다.
        Sub sub = new Sub();
        Type type = sub.getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) type;
        Type[] actualTypeArguments = pType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            // actualTypeArgument = class java.lang.String
            System.out.println("actualTypeArgument = " + actualTypeArgument);
        }
    }

}
