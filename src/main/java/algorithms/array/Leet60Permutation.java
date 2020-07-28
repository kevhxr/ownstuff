package algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet60Permutation {
    private boolean[] used;
    private int[] factorial;
    private int n;
    private int k;
    private List<Integer> path;

    public static void main(String[] args) {
        Leet60Permutation sol = new Leet60Permutation();
        sol.getPermutation(4,9);
    }

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        path = new ArrayList<>(n);
        dfs(0);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer c : path) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private void dfs(int index) {
        if (index == n) {
            return;
        }
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.add(i);
            used[i] = true;
            dfs(index + 1);
        }
    }
}
