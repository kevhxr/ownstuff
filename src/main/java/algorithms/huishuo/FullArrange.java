package algorithms.huishuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FullArrange {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        permute(a);
    }

    public static void backtrack(int n,
                          ArrayList<Integer> output,
                          List<List<Integer>> res,
                          int first) {

        if (first == n){
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums){
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }
}
