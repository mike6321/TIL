package choi.redaytolivecoding.bfs_dfs;

import java.util.Objects;

/**
 * 전위순회
 * */
public class e_이진트리순회_1 {

    private Node root;

    public static void main(String[] args) {
        e_이진트리순회_1 tree = new e_이진트리순회_1();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.dfs(tree.root);
    }

    private void dfs(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        System.out.print(root.data + " ");
        dfs(root.lt);
        dfs(root.rt);
    }


}
