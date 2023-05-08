package choi.resursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 피보나치 수열 (array)
 * */
public class Problem04_1 {

    public static void main(String[] args) {
        int n = 10;
        Problem04_1 problem = new Problem04_1();
        problem.arraySolution(n);
    }

    private  void arraySolution(int n) {
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
