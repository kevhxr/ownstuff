package algorithms.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class treeMostDis {
    public static void main(String[] args) {
        System.out.println(1<<5);
        TreeNode tree = new TreeNode(8);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(6);
        tree.left.right = new TreeNode(7);
        tree.left.left = new TreeNode(8);

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(3);
        tree2.right = new TreeNode(10);
        tree2.left.right = new TreeNode(21);
        tree2.left.left = new TreeNode(20);
        tree2.right.left = new TreeNode(1);


        List<Integer> list = new ArrayList<>();
        treeDp(tree,tree.val,list);
        list.stream().forEach(a-> System.out.print(a+","));
        System.out.println();
        System.out.println(list.size());

        System.out.println();

        List<Integer> list2 = new ArrayList<>();
        treeDp(tree2,tree2.val,list2);
        list2.stream().forEach(a-> System.out.print(a+","));
        System.out.println();
        System.out.println(list2.size());
    }

    public static void solution(TreeNode tree) {
        HashSet<Integer> leftMax = new HashSet<>();
        HashSet<Integer> rightMax = new HashSet<>();
        leftMax.add(tree.val);
        rightMax.add(tree.val);
        treeDp(tree.left, leftMax);
        treeDp(tree.right, rightMax);
        System.out.println(Math.max(leftMax.size(), rightMax.size()));
    }


    public static void treeDp(TreeNode tree, HashSet<Integer> set) {

        if (tree == null) {
            return;
        }
        treeDp(tree.left, set);
        treeDp(tree.right, set);
        set.add(tree.val);
    }

    public static void treeDp(TreeNode tree, int target, List<Integer> list){
        if(tree == null){
            return;
        }
        treeDp(tree.left,Math.max(tree.val,target),list);
        treeDp(tree.right,Math.max(tree.val,target),list);
        if(tree.val >= target){
            list.add(tree.val);
        }
    }
}
