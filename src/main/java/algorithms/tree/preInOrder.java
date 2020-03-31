package algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class preInOrder {
    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        /*TreeNode treeNode = buildTree(pre, in);
        System.out.println(treeNode.val);
        */
        generateTrees(3);
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        return robot(pre, in, 0, 0, in.length - 1);
    }

    public static TreeNode robot(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        if (preStart >= pre.length || inStart > inEnd) return null;
        // 找到pos
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = robot(pre, in, preStart + 1, inStart, index - 1);
        root.right = robot(pre, in, preStart + 1 + index - inStart, index + 1, inEnd);
        return root;
    }


    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n == 0)
            return res;
        res = doGenerate(1, n);
        return res;
    }

    public static List<TreeNode> doGenerate(int start, int end) {
        List<TreeNode> child = new ArrayList<TreeNode>();
        if (start > end) {
            child.add(null);//这里不要忘记加上null
            return child;
        }

        for (int index = start; index <= end; index++) {
            List<TreeNode> left = doGenerate(start, index - 1);
            List<TreeNode> right = doGenerate(index + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(index);
                    root.left = l;
                    root.right = r;
                    child.add(root);
                }
            }
        }
        return child;
    }
}
