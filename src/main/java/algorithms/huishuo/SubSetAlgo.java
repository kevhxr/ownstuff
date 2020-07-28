package algorithms.huishuo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SubSetAlgo {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        backTracking(nums).stream().forEach(a -> System.out.println(a));
        for (int i = 0; i <3 ; ++i) {
            System.out.println(i);
        }
    }


    public static List<List<Integer>> recurSubsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubSet = new ArrayList();
            for (List<Integer> curr : output) {
                newSubSet.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> subset : newSubSet) {
                output.add(subset);
            }
        }
        return output;
    }

    public static void backtrack(int first, ArrayList<Integer> curr, int[] nums
            , List<List<Integer>> output, int n, int k) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
        }
        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums, output, n, k);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }


    public static List<List<Integer>> backTracking(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        int k;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<>(), nums, output, n, k);
        }
        Queue<Pair<Integer, Integer>> stack = new LinkedList<>();
        return output;
    }
}