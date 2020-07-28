package algorithms.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class FindDepth {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(6);
        tree.left.right = new TreeNode(7);
        tree.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(8);

        findDepth(tree);
    }

    public static void findDepth(TreeNode root) {

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            while (len-- > 0) {
                TreeNode temp = queue.poll();
                if (temp != null && temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp != null && temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        System.out.println(depth);
    }
}
