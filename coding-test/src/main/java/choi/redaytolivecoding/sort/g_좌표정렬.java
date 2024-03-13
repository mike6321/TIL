package choi.redaytolivecoding.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class g_좌표정렬 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    List<Point> array = new ArrayList<>();
    for (int i = 0; i < num; i++) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        array.add(new Point(x, y));
    }

    Collections.sort(array);
    for (Point point : array) {
        System.out.println(point.getX() + " " + point.getY());
    }
}



}
// point! : 정렬 방법 (Comparable)
class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 오름차순 (양수리턴)
    @Override
    public int compareTo(Point o) {
        if (o.x == this.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }

}
