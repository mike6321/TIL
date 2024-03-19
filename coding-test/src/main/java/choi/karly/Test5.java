package choi.karly;
import java.io.*;
import java.util.*;

public class Test5 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Container> containers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            containers.add(new Container(size));
        }

        Collections.sort(containers);
        int maxHeight = calculateMaxHeight(containers);

        System.out.println("Hello Goorm! Your input is " + maxHeight);
    }

    public static int calculateMaxHeight(List<Container> containers) {
        if (containers.isEmpty()) {
            return 0;
        }

        int maxHeight = 1;
        boolean currentColor = containers.get(0).getIsBlack();
        for(Container container : containers) {
            if (container.getIsBlack() != currentColor) {
                maxHeight++;
                currentColor = container.getIsBlack();
            }
        }
        return maxHeight;
    }

}


class Container implements Comparable<Container> {

    private final int size;
    private final boolean isBlack;

    public Container(int size) {
        this.size = size;
        this.isBlack = size > 0;
    }

    public int compareTo(Container other) {
        return Math.abs(other.getSize()) - Math.abs(this.size);
    }

    public int getSize() {
        return this.size;
    }

    public boolean getIsBlack() {
        return this.isBlack;
    }

}
