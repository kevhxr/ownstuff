package algorithms.array;

import java.util.Arrays;

public class ConstructArr66 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        constructArr(arr);
    }

    public static int[] constructArr(int[] a) {
        if (0 == a.length) {
            return new int[0];
        }
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1;
        //left
        for (int i = 1; i < length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        Arrays.stream(b).forEach(bb -> System.out.print(bb + ","));
        //right
        int temp = 1;
        for (int j = length - 2; j >= 0; j--) {
            temp *= a[j + 1];
            b[j] *= temp;
        }
        System.out.println();
        Arrays.stream(b).forEach(bb -> System.out.print(bb + ","));
        return b;
    }
}
