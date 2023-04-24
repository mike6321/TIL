package choi.resursive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS tree
 * */
public class Problem11 {

    private Node root;

    public static void main(String[] args) {
        Problem11 tree = init();
        int result = tree.bfs(tree.root);
        System.out.println(result);
    }

    private int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Node current = queue.poll();
                if (current.lt == null && current.rt == null) {
                    return level;
                }
                if (current.lt != null) {
                    queue.add(current.lt);
                }
                if (current.rt != null) {
                    queue.add(current.rt);
                }
            }
            level++;
        }
        return 0;
    }

    private static Problem11 init() {
        Problem11 tree = new Problem11();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        return tree;
    }

    static class Node {
        private int data;
        private Node lt;
        private Node rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }

    }
    
}
