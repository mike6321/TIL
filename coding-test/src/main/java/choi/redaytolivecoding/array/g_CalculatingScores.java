package choi.redaytolivecoding.array;

import java.util.Scanner;

public class g_CalculatingScores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        /**
         * 1 0 1 1 1 0 0 1 1 0
         * */
        int count = 0;
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if (array[i] == 0) {
                count = 0;
                continue;
            }
            count++;
            sum += count;
        }
        System.out.println(sum);

    }

}
