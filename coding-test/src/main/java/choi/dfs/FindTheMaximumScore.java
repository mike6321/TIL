package choi.dfs;

import java.util.Scanner;


/**
 * https://cote.inflearn.com/contest/10/problem/08-03

5 20
10 5
25 12
15 8
6 3
7 4
 * */
public class FindTheMaximumScore {

    private static int n;
    private static int limitTime;
    private static int[] scoreArray;
    private static int[] timeArray;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        limitTime = scanner.nextInt();
        scoreArray = new int[n];
        timeArray = new int[n];

        for (int i = 0; i < n; i++) {
            scoreArray[i] = scanner.nextInt();
            timeArray[i] = scanner.nextInt();
        }

        FindTheMaximumScore findTheMaximumScore = new FindTheMaximumScore();
        findTheMaximumScore.dfs(0, 0, 0);
        System.out.println(answer);
    }

    private void dfs(int level, int sum, int time) {
        if (limitTime < time) {
            return;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level+1, sum + scoreArray[level], time + timeArray[level]);
            dfs(level+1, sum, time);
        }

    }

}
