package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubArr {

    public static void main(String[] args) {
        int[] a = {2,3,1,2,4,3};
        //minSubArrayLen(7,a);
        int[] b = {1,2,3,4};
        //productExceptSelf(b);
        int[] c = {1,2,3,4,2};
        //System.out.println(findDuplicate(c));
        int[] d = {4,3,2,7,8,2,3,1};
        findDuplicates(d);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0, end = 0, sum = 0, ans = Integer.MAX_VALUE;
        while(end < nums.length && start < nums.length) {
            // 滑动窗口，end
            while(end < nums.length && sum < s) {
                sum += nums[end++];
                if(sum >= s) {
                    ans = Math.min(ans, end - start);
                }
            }
            // 滑动窗口，start
            while(start < nums.length && sum >= s) {
                sum -= nums[start++];
                if(sum < s) {
                    ans = Math.min(ans, end - start + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] fwd = new int[n], bwd = new int[n];
        fwd[0] = 1; bwd[n - 1] = 1;
        for (int i = 1; i < n; ++i) {
            fwd[i] = fwd[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; --i) {
            bwd[i] = bwd[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; ++i) {
            res[i] = fwd[i] * bwd[i];
        }
        return res;
    }


    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        // 找到快慢指针相遇的地方
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        int find = 0;
        // 用一个新指针从头开始，直到和慢指针相遇
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }


    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
