package choi.redaytolivecoding.hackerrank;

import java.util.List;

public class Test02 {

    public static void main(String[] args) {
        int result = jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 0));
        System.out.println(result);
    }

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int jumps = 0;
        int i = 0;

        while (i < c.size() - 1) {
            if (i + 2 < c.size() - 1) {
                i += 2;
            } else {
                i++;
            }
            jumps++;
        }

        return jumps;
    }


}
