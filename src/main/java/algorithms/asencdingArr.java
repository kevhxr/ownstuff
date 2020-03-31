package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class asencdingArr {

    public static void main(String[] args) {
/*        System.out.println(5&0x1);
        System.out.println(5/2+1);*/
        int A[] = {2, 2, 2, 2, 1, 2, -1, 2, 1, 3};
        solution(A);

    }

    public static void solution(int[] a) {

        int p = 0;
        int q = 0;
        int maxSize = 1;
        List<Integer> maxpList = new ArrayList<>();

        for (int i = p; i < a.length - 1; i++) {

            if (a[i + 1] > a[i] && i <= a.length - 2) {
                q = i + 1;
            } else {
                if (maxpList.size() > 0) {
                    if (q - p + 1 > maxSize) {
                        maxpList.clear();
                        maxpList.add(p);
                        maxSize = q - p + 1;
                    } else if (q - p + 1 == maxSize) {
                        maxpList.add(p);
                    }
                } else {
                    maxpList.add(p);
                }
                p = i + 1;
                q = p;
            }
        }

        if (q - p + 1 > maxSize) {
            maxpList.clear();
            maxpList.add(p);
            maxSize = q - p + 1;
        } else if (q - p + 1 == maxSize) {
            maxpList.add(p);
        }

        maxpList.stream().forEach(aa -> System.out.println(aa));
        System.out.println();
        System.out.println(maxSize);
    }
}
