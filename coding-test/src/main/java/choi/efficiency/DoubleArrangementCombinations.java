package choi.efficiency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 두 배열 합치기
 *
 * https://cote.inflearn.com/contest/10/problem/03-01
3
1 3 5
5
2 3 6 7 9
 * */
public class DoubleArrangementCombinations {

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            result.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            result.add(scanner.nextInt());
        }

        result.stream().sorted()
                .forEach(num -> System.out.print(num + " "));
    }

}
