package algorithms;

public class trapppingW {

    public static void main(String[] args) {

        System.out.println(3/2);


        int[] ss = {4,5,6,3,4,8,9};
        System.out.println(search(ss,8));
        int[] w = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] rd = {1, 1, 1, 2, 2, 3};
        int[] re = {3, 2, 2, 3};
        removeDuplicates(rd);
        int[] rd2 = {1, 1, 1, 2, 2, 3};
        removeDuplicates2(rd2);
        removeElement(re, 3);
    }

    public static int trap(int[] height) {
        if (height == null) return 0;
        int ans = 0, maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            // 左位置的左边的最高值，右位置的右边的最高值
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft < maxRight) {
                ans += maxLeft - height[left];
                left++;
            } else {
                ans += maxRight - height[right];
                right--;
            }
            System.out.println(ans);
        }
        return ans;
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                nums[++count] = nums[i];
            }
            System.out.println(count);
        }
        return count + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length <= 2) return nums.length;
        int count = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count] || (nums[i] == nums[count] && nums[i] != nums[count - 1])) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }


    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] < nums[mid]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else if (nums[left] > nums[mid]) {
                if (target >= nums[left] || target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else
                left++;
        }
        return false;
    }

}
