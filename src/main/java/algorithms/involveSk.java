package algorithms;

public class involveSk {

    public static void main(String[] args) {
        int[] a = {5, 4, 0, 3,1, 6, 2};
        //int[] a = {1,1,2};
        int sum = doTest(a);
        System.out.println("===========");
        System.out.println(sum);
        //invoke2(a);
    }

    public static int doTest(int[] a) {
        int maxSum = 1;
        for (int i = 0; i < a.length; i++) {
            int sum = 1;
            if (a[i] != i) {
                //sum += invoke(a, a[i], i);
                sum += invoke2(a,i);
            }
            System.out.println(sum);
            maxSum = maxSum > sum ? maxSum : sum;
        }
        return maxSum;
    }

    public static int invoke(int[] a, int pos, int end) {
        if (a[pos] != end) {
            pos = a[pos];
            return 1 + invoke(a, pos, end);
        }
        return 1;
    }


    public static int invoke2(int[] a, int target) {
        int count = 0;
        int pos = target;
        while (a[pos] != target) {
            pos = a[pos];
            count++;
        }
        return count;

    }
}
