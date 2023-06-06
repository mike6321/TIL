package choi.array;

import java.util.Scanner;

/**
 * 봉우리
 * https://cote.inflearn.com/contest/10/problem/02-10
 *
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2
 * */
public class SummitOfMountain {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int target = array[i][j];
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (array[nx][ny] >= target) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
