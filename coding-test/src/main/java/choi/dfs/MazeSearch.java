package choi.dfs;

import java.util.Scanner;

/**
 * 미로탐색
 * https://cote.inflearn.com/contest/10/problem/08-10
 *
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0
 * */
public class MazeSearch {

    private static int[][] array = new int[8][8];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        array[1][1] = 1;

        MazeSearch mazeSearch = new MazeSearch();
        mazeSearch.dfs(1, 1);
        System.out.println(answer);

    }

    public void dfs(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 1 && nextX <= 7 && nextY >= 1 && nextY <= 7 && array[nextX][nextY] == 0) {
                    array[nextX][nextY] = 1;
                    dfs(nextX, nextY);
                    array[nextX][nextY] = 0;
                }
            }
        }
    }

}
