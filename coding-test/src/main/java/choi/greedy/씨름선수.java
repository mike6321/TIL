package choi.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://cote.inflearn.com/contest/10/problem/09-01
5
172 67
183 65
180 70
170 72
181 60
 * */
public class 씨름선수 {

    public static void main(String[] args) {
        List<Body> bodies = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            bodies.add(new Body(scanner.nextInt(), scanner.nextInt()));
        }
        씨름선수 problem = new 씨름선수();
        int count = problem.solution(bodies, n);
        System.out.println(count);
    }

    private int solution(List<Body> bodies, int n) {
        int answer = 0;
        List<Body> sortedBodies = bodies.stream()
                .sorted(Comparator.comparing(Body::getHeight).reversed())
                .collect(Collectors.toList());
        int max = Integer.MIN_VALUE;
        for (Body sortedBody : sortedBodies) {
            int weight = sortedBody.getWeight();
            if (weight > max) {
                max = weight;
                answer++;
            }
        }
        return answer;
    }

    static class Body {

        private final int height;
        private final int weight;

        Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }
    }

}
