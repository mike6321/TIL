package choi.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 공주구하기
 * https://cote.inflearn.com/contest/10/problem/05-06
 *
 * 8 3
 * */
public class SavingPrincesses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) {
                result = queue.poll();
            }
        }

        System.out.println(result);
    }

}
