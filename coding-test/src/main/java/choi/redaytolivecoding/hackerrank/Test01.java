package choi.redaytolivecoding.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {

    public static void main(String[] args) {
        int result = sockMerchant(9, List.of(1, 1, 3, 1, 2, 1, 3, 3, 3, 3));
        System.out.println(result);
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> colorCount = new HashMap<>();
        for (Integer color : ar) {
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }

        int pairs = 0;
        for (int color : colorCount.values()) {
            pairs += color / 2;
        }

        return pairs;
    }

}
