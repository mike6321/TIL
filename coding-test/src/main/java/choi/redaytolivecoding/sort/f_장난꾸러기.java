package choi.redaytolivecoding.sort;

import java.util.Arrays;
import java.util.Scanner;

public class f_장난꾸러기 {

    public static void main(String[] args) {
//        120 125 152 130 135 135 143 127 160
//        120 125 127 130 135 135 143 152 160

        // point! 값 복사, 정렬 후 비교
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        int[] originArray = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        originArray = array.clone();
        Arrays.sort(array);

        for (int i = 0; i < num; i++) {
            if (array[i] != originArray[i]) {
                System.out.print(i + 1 + " ");
            }
        }
    }

}
