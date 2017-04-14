package io.shashanktyagi.hackerrank;

import java.util.Scanner;
import java.io.PrintWriter;

public class TheCoinChangeProblem {
    long[][] res;
    int[] c;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        res = new long[m + 1][n + 1];
        c = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            c[i] = in.nextInt();
        }
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                res[i][j] = -1;
            }
        }
        out.print(Long.toString(solve2(1, n)));
    }

    private long solve2(int i, int n) {
        if (i >= c.length || n < 0) {
            return 0;
        }
        if (n == 0) return res[i][n] = 1;
        if (res[i][n] == -1) {
            res[i][n] = solve2(i + 1, n) + solve2(i, n - c[i]);
        }
        return res[i][n];
    }
}
