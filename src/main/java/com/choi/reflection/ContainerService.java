package com.choi.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        Field[] declaredFields = classType.getDeclaredFields();
        Arrays.stream(declaredFields)
                .forEach(field -> {
                    if (field.getAnnotation(Inject.class) != null) {
                        Class<?> type = field.getType();
                        Object fieldInstance = createInstance(type);
                        field.setAccessible(true);
                        try {
                            field.set(instance, fieldInstance);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException();
                        }
                    }
                });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null)
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }

}
