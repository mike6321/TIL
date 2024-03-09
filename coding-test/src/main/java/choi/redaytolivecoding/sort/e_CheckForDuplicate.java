package choi.redaytolivecoding.sort;

import java.util.Arrays;
import java.util.Scanner;

public class e_CheckForDuplicate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        // point! : 미리 정렬 후 체크
        Arrays.sort(array);

        String answer = "U";
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i+1]) {
                answer = "D";
            }
        }

        System.out.println(answer);
    }

}
