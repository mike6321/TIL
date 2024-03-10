package choi.redaytolivecoding.array;

import java.util.Scanner;

public class h_등수구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        int[] answer = new int[num];
        /**
         * 5
         * 87 89 92 100 76
         * */

        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < num; i++) {
            int count = 1;
            int target = array[i];
            for (int j = 0; j < num; j++) {
                if (j == i) {
                    continue;
                }

                if (target < array[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}
