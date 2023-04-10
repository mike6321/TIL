package choi.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://cote.inflearn.com/contest/10/problem/06-07
 * */
public class CoordinateAlignment {

    public static void main(String[] args) {
        List<Dot> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            list.add(new Dot(in.nextInt(), in.nextInt()));
        }

        List<Dot> result1 = list.stream()
                .sorted(new Comparator<Dot>() {
                    @Override
                    public int compare(Dot o1, Dot o2) {
                        if (o1.x > o2.x) {
                            return 1;
                        } else if (o1.x < o2.x) {
                            return -1;
                        }
                        return 0;
                    }
                })
                .collect(Collectors.toList());

        List<Dot> result2 = result1.stream()
                .sorted(new Comparator<Dot>() {
                    @Override
                    public int compare(Dot o1, Dot o2) {
                        if (o1.x == o2.x) {
                            if (o1.y > o2.y) {
                                return 1;
                            } else if (o1.y < o2.y) {
                                return -1;
                            }
                        }
                        return 0;
                    }
                })
                .collect(Collectors.toList());
        for (Dot dot : result2) {
            System.out.println(dot.x + " " + dot.y);
        }


    }

    static class Dot {

        private int x;
        private int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
