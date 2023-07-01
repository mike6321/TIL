package choi.greedy;

import java.util.*;

/**
 * https://cote.inflearn.com/contest/10/problem/09-04
 *
6
50 2
20 1
40 2
60 3
30 3
30 1
 * */
public class 최대수입스케쥴 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            int time = scanner.nextInt();
            lectures.add(new Lecture(money, time));
            max = Integer.max(max, time);
        }

        최대수입스케쥴 problem = new 최대수입스케쥴();
        int answer = problem.solution(n, lectures);
        System.out.println(answer);
    }

    private int solution(int n, List<Lecture> lectures) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        lectures.sort(Comparator.comparingInt(Lecture::getTime));

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for ( ; j < n; j++) {
                if (lectures.get(j).getTime() < i) {
                    break;
                }
                priorityQueue.offer(lectures.get(j).getMoney());
            }
            if (!priorityQueue.isEmpty()) {
                answer += priorityQueue.poll();
            }
        }
        return 0;
    }

    static class Lecture {
        private final int money;
        private final int time;

        Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        public int getMoney() {
            return money;
        }

        public int getTime() {
            return time;
        }
    }
}
