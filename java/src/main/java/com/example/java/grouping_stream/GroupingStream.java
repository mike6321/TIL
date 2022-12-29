package com.example.java.grouping_stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingStream {

    public static void main(String[] args) {
        List<Test> dummyData = init();

        Map<Long, List<Test>> result = dummyData.stream()
                .collect(Collectors.groupingBy(Test::getBannerTypeId));

        for (Long aLong : result.keySet()) {
            System.out.println(aLong);
        }


    }

    private static List<Test> init() {
        Test test1 = new Test(1L, 78342L, 19759L);
        Test test2 = new Test(1L, 78343L, 19760L);
        Test test3 = new Test(2L, 78344L, 19761L);
        Test test4 = new Test(2L, 78345L, 19762L);
        Test test5 = new Test(3L, 78346L, 19763L);
        return List.of(test1, test2, test3, test4, test5);
    }


}
