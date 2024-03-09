package choi.redaytolivecoding.sort;

import java.util.Scanner;

public class d_LRU {

    /**
     * 0 0 0 0 0
     * [1] 1 0 0 0 0
     * [2] 2 1 0 0 0
     * [3] 3 2 1 0 0
     * [2] 2 3 1 0 0
     * [6] 6 2 3 1 0
     * [2] 2 6 3 1 0
     * [3] 3 2 6 1 0
     * [5] 5 3 2 6 1
     * [7] 7 5 3 2 6
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }


        int[] cache = new int[length];

        for (int i = 0; i < array.length; i++) {
            // point! : cache된 데이터가 있는지 체크하는 방식
            int position = -1;

            for (int j = 0; j < cache.length; j++) {
                if (cache[j] == array[i]) {
                    position = j;
                }
            }

            // miss
            if (position == -1) {
                // point! : 한칸 씩 밀기
                for (int k = cache.length -1; k >= 1; k--) {
                    cache[k] = cache[k-1];
                }
                cache[0] = array[i];
            }
            // hit
            else {
                // point! : 한칸 씩 밀기
                for (int k = position; k >= 1;  k--) {
                    cache[k] = cache[k-1];
                }
                cache[0] = array[i];
            }
        }

        for (int i : cache) {
            System.out.print(i + " ");
        }

    }


}
