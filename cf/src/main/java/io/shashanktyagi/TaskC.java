package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int d = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] xs = new int[d + 1];
        int[] ys = new int[d + 1];
        int[] xe = new int[d + 1];
        int[] ye = new int[d + 1];
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        int[] t = new int[m + 1];
        int[] b = new int[m + 1];
        for (int i = 1; i <= d; i++) {
            xs[i] = in.nextInt();
            ys[i] = in.nextInt();
            xe[i] = in.nextInt();
            ye[i] = in.nextInt();
            l[Math.min(xs[i], xe[i])] = 1;
            r[Math.max(xs[i], xe[i])] = 1;
            t[Math.min(ys[i], ye[i])] = 1;
            b[Math.max(ys[i], ye[i])] = 1;
        }
        for (int j = 1; j <= n; j++) {
            l[j] += l[j - 1];
        }
        for (int j = n - 1; j >= 1; j--) {
            r[j] += r[j + 1];
        }
        for (int j = 1; j <= m; j++) {
            t[j] += t[j - 1];
        }
        for (int j = m - 1; j >= 1; j--) {
            b[j] += b[j + 1];
        }
        int cntl = in.nextInt();
        int cntr = in.nextInt();
        int cntt = in.nextInt();
        int cntb = in.nextInt();
        for (int i = 1; i <= d; i++) {
            if (l[xe[i]] == cntl
                    && r[xs[i]] == cntr
                    && t[ye[i]] == cntt
                    && b[ys[i]] == cntb) {
                out.write(Integer.toString(i));
                return;
            }
        }
        out.write("-1");

    }
}
