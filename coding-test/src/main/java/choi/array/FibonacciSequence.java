package choi.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-04
 * */
public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = result.size();
            if (size == 0 || size == 1) {
                result.add(1);
                continue;
            }

            int sum = result.get(i - 1) + result.get(i - 2);
            result.add(sum);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

}
