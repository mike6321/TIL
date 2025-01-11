package com.example.java.generic.typetoken.step03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorite {

    private final Map<Class<?>, Object> map = new HashMap<>();

    // 조금 더 안전하고 런타임 시 에러를 빨리 발견할 수 있도록 수정
    public <T> void put(Class<T> clazz, T object) {
        map.put(Objects.requireNonNull(clazz), clazz.cast(object));
    }

    public <T> T get(Class<T> clazz) {
        return clazz.cast(map.get(clazz));
    }

    public static void main(String[] args) {
        Favorite favorite = new Favorite();
        favorite.put(String.class, "Java");
        favorite.put(Integer.class, 1);

//        System.out.println(favorite.get(String.class));
//        System.out.println(favorite.get(Integer.class));



        favorite.put(List.class, List.of(1, 2, 3));
        favorite.put(List.class, List.of("a", "b", "c"));

        /**
         * "a", "b", "c" 가 엎어쳐버리는 문제가 발생
         * List<String>.class
         * List<Integer>.class
         * 이건 불가능
         *
         * 구분할 순 없을까?
         * */
        favorite.get(List.class).forEach(System.out::println);
    }

}
