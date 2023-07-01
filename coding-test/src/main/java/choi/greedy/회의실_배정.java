package choi.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/09-02
 *
5
1 3
2 3
3 5
4 6
5 7
 * */
public class 회의실_배정 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Time> times = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            times.add(new Time(scanner.nextInt(), scanner.nextInt()));
        }

        회의실_배정 problem = new 회의실_배정();
        int answer = problem.solution(n, times);
        System.out.println(answer);
    }

    private int solution(int n, List<Time> times) {
        int answer = 0;
        times.sort((o1, o2) -> {
            if (o1.getEnd() == o2.getEnd()) {
                return o1.getStart() - o2.getStart();
            } else {
                return o1.getEnd() - o2.getEnd();
            }
        });

        int endTime = 0;
        for (Time time : times) {
            if (time.getStart() >= endTime) {
                answer++;
                endTime = time.getEnd();
            }
        }

        return answer;
    }


    static class Time {

        private final int start;
        private final int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

    }
}
