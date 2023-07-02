package choi.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/09-03
 *
5
14 18
12 15
15 20
20 30
5 14
 * */
public class 결혼식 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Time> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            times.add(new Time(start, 's'));
            times.add(new Time(end, 'e'));
        }

        결혼식 problem = new 결혼식();
        int answer = problem.solution(n , times);
        System.out.println(answer);
    }

    private int solution(int n, List<Time> times) {
        times.sort((o1, o2) -> {
            if (o1.getTime() == o2.getTime()) {
                return o1.getState() - o2.getState();
            } else {
                return o1.getTime() - o2.getTime();
            }
        });

        int answer = Integer.MIN_VALUE;
        int count = 0;

        for (Time time : times) {
            if (time.getState() == 's') {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }

    static class Time {
        private final int time;
        private final char state;

        Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        public int getTime() {
            return time;
        }

        public char getState() {
            return state;
        }
    }
}
