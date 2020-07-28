package algorithms.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Leet1028PreOrderBinaryTree {
    public static void main(String[] args) {
        recoverFromPreorder("1-2--3--4-5--6--7");
    }

    public static TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);

            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            }else{
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }

            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }

    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] arr1 = new int[26];
        for (int i = 0; i <s1.length() ; i++) {
            arr1[s1.charAt(i)]++;
            arr1[s2.charAt(i)]--;
        }
        for (int i : arr1) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    
}
