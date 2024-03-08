package choi.redaytolivecoding.array;

import java.util.Scanner;

public class j_MountainTop {


    public static void main(String[] args) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] array = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                array[i][j] = scanner.nextInt();
            }
        }


        /**
         * point : 주변 탐색
         * */
        int answer = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < num && ny >= 0 && ny < num && array[nx][ny] >= array[i][j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }

            }
        }

        System.out.println(answer);



    }

}
