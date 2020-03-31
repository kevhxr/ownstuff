package algorithms;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] a = {1, 2, 9};
        int[][] matrix = {
                {1, 1, 2, 0},
                {3, 0, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        //printArr(plusOne(a));
    }

    public static int[] plusOne(int[] origin) {
        if (origin == null || origin.length == 0) {
            return null;
        }

        int[] res = new int[origin.length + 1];
        origin[origin.length - 1]++;

        for (int i = origin.length - 1; i >= 0; i--) {
            res[i + 1] += origin[i];
            //10以下的除以10为0，n1/10=n(n=0,1...)
            res[i] += res[i + 1] / 10;
            //10以下的%10为自己，mn%10=n(m>0,n>=0)
            res[i + 1] %= 10;
        }

        if (res[0] == 0) {
            return Arrays.copyOfRange(res, 1, res.length);
        } else {
            return res;
        }
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }


    public static void setZeroes(int[][] matrix) {

        Arrays.stream(matrix).forEach(a -> {
            printArr(a);
            System.out.println();
        });

        System.out.println("==============");
        boolean rowFlag = false;
        //判断首行
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        boolean colFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        Arrays.stream(matrix).forEach(a -> {
            printArr(a);
            System.out.println();
        });
        System.out.println("1==============");

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        Arrays.stream(matrix).forEach(a -> {
            printArr(a);
            System.out.println();
        });
        System.out.println("2==============");
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        Arrays.stream(matrix).forEach(a -> {
            printArr(a);
            System.out.println();
        });
        System.out.println("3==============");
        if (rowFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        Arrays.stream(matrix).forEach(a -> {
            printArr(a);
            System.out.println();
        });
    }

}
