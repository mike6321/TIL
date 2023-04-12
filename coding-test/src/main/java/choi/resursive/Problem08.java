package choi.resursive;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리 레벨탐색(BFS : Breadth-First Search)
 * */
public class Problem08 {

    private Node root;

    public static void main(String[] args) {
        Problem08 tree = init();
        tree.bfs(tree.root);
    }

    private static Problem08 init() {
        Problem08 tree = new Problem08();
        tree.root = new Problem08.Node(1);

        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        return tree;
    }

    private void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            System.out.print(level + " : ");

            for (int i = 0; i < length ; i++) {
                Node poll = queue.poll();
                System.out.print(poll.data + " ");

                if (poll.lt != null) {
                    queue.add(poll.lt);
                }
                if (poll.rt != null) {
                    queue.add(poll.rt);
                }
            }
            level++;
            System.out.println();
        }
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
