package choi.redaytolivecoding.sort;

import java.util.Arrays;
import java.util.Scanner;

public class h_BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int target = scanner.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        // point ! : 이분검색
        // 정렬이 되어있어야한다.
        Arrays.sort(array);

        int lt = 0;
        int rt = num - 1;
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (array[mid] == target) {
                answer = mid + 1;
                break;
            }
            if (array[mid] > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }

}
