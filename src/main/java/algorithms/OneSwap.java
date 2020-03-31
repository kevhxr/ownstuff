package algorithms;

public class OneSwap {


    public static void main(String[] args) {
        int[] a = {1, 5, 3, 3, 7, 1};
        int[] a2 = {1, 3, 5, 3, 4};
        int[] a3 = {1, 8, 3, 3, 7, 1};
        int[] a4 = {1, 3, 5, 3, 2, 6};
        int[] a5 = {1, 3, 3, 2, 6};
        int[] a6 = {5, 3, 3, 2, 6};

        //solution(a4);
        System.out.println(solution(a5));
        System.out.println(solution(a3));
        System.out.println(solution(a2));
        System.out.println(solution(a));
    }

    public static boolean solution(int[] a) {
        int swapNum = 0;
        int start = 0;
        int end = a.length - 1;
        int localMaxIndex = 0;
        while (start < a.length - 1) {
            if (a[start + 1] < a[start]) {
                if (swapNum > 0 ) {
                    return false;
                }
                while (a[end] > a[start]) {
                    end--;
                }
                if (start != 0 && a[end] < localMaxIndex) {
                    return false;
                }
                swap(a, start, end);
                swapNum++;
                start--;
            } else if (a[start + 1] < a[start]) {
                localMaxIndex++;
            }
            start++;
        }
        return swapNum == 1;
    }

    public static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}
