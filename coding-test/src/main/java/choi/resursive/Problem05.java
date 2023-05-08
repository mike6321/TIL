package choi.resursive;

import java.util.Objects;

/**
 * 이진트리순회 (DFS)
 * https://user-images.githubusercontent.com/33277588/230551541-62e98d1f-6004-4dd2-a6af-7401ddddaf74.png
 * */
public class Problem05 {

    private Node root;

    public static void main(String[] args) {
        Problem05 tree = init();
        tree.dfs(tree.root);
    }

    private static Problem05 init() {
        Problem05 tree = new Problem05();
        tree.root = new Node(1);

        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        return tree;
    }

    public void dfs(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        // 전위순회 1 2 4 5 3 6 7
//        System.out.print(root.data + " ");

        dfs(root.lt);
        // 중위순회 4 2 5 1 6 3 7
//        System.out.print(root.data + " ");
        dfs(root.rt);

        // 후위순회 4 5 2 6 7 3 1
        System.out.print(root.data + " ");
    }

    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            lt = null;
            rt = null;
        }

    }
}
