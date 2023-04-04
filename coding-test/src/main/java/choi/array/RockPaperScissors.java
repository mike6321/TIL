package choi.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-03
 * */
public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                if (k == 0) {
                    arr1[i] = in.nextInt();
                }
                if (k == 1) {
                    arr2[i] = in.nextInt();
                }
            }
        }

        //  1:가위, 2:바위, 3:보
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i]) {
                result.add("D");
            } else if (arr1[i] == 1 && arr2[i] == 3) {
                result.add("A");
            } else if (arr1[i] == 2 && arr2[i] == 1) {
                result.add("A");
            } else if (arr1[i] == 3 && arr2[i] == 2) {
                result.add("A");
            } else {
                result.add("B");
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

}
