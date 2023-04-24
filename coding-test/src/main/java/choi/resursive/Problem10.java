package choi.resursive;

/**
 * DFS tree
 * */
public class Problem10 {

    private Node root;

    public static void main(String[] args) {
        Problem10 tree = init();
        int result = tree.dfs(0, tree.root);

        System.out.println(result);
    }

    private int dfs(int level, Node root) {
        if (root.lt == null && root.rt == null) {
            return level;
        }

        return Math.min(dfs(level + 1, root.lt), dfs(level + 1, root.rt));
    }

    private static Problem10 init() {
        Problem10 tree = new Problem10();
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
