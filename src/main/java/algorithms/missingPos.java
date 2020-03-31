package algorithms;

public class missingPos {

    public static void main(String[] args) {
        int[] n = {-1,-1,-1};
        System.out.println(firstMissingPositive(n));
    }

    public static int firstMissingPositive(int[] n) {
        if(n == null) return 0;
        for(int i = 0; i < n.length; i++) {
            while(n[i] > 0 && n[i] <= n.length && n[i] != n[n[i] - 1]) {
                swap(n, i, n[i] - 1);
            }
        }
        // 遍历，找出n[i] != i + 1的结果
        for(int i = 0; i < n.length; i++) {
            if(n[i] != i + 1) return i + 1;
        }
        return n.length + 1;
    }
    public static void swap(int[] n, int a, int b) {
        int tmp = n[a];
        n[a] = n[b];
        n[b] = tmp;
    }
}
