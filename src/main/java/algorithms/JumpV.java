package algorithms;

public class JumpV {

    public static void main(String[] args) {

        int[] ss = {2,3,1,1,4,1};
        System.out.println(canJump(ss));
    }

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        // farest[i] 表示[0, i]能跳到的最远位置
        int[] farest = new int[nums.length];
        farest[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            // 若前面断档，则后面无解
            if(farest[i - 1] == i - 1) break;
            farest[i] = Math.max(farest[i - 1], nums[i] + i);
        }
        return farest[nums.length - 1] != 0;
    }

    public static  boolean canJump2(int[] nums) {
        int n = nums.length, reach = 0;
        for (int i = 0; i < n; ++i) {
            if (i > reach || reach >= n - 1) break;
            reach =  Math.max(reach, i + nums[i]);
        }
        return reach >= n - 1;
    }

}
