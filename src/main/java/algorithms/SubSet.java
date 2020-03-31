package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

    public static void main(String[] args) {

        int[] arr = {1,2,2};
        printArr(subsets(arr));

    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null) return ans;
        robot(0, nums, ans, new ArrayList<Integer>());
        return ans;
    }
    public static void robot(int start, int[] nums, List<List<Integer>> ans, List<Integer> tmp) {
        ans.add(new ArrayList(tmp));
        for(int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            robot(i + 1, nums, ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }



    public static void printArr(List<List<Integer>> arr) {
       arr.stream().forEach(a -> {
           System.out.print("arr: ");
           a.stream().forEach(b-> System.out.print(b+" "));
           System.out.println();
       });
    }

}
