package choi.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Naughty {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] copyArr = arr.clone(); // 깊은 복사
        Arrays.sort(copyArr);


        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != copyArr[i]) {
                result.add(i + 1);
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

}
