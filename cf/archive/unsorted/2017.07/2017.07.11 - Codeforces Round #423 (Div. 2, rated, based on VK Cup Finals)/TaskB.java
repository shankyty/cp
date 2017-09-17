package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        String[] bw = new String[n];
        for (int i = 0; i < n; i++) {
            bw[i] = in.next();
        }
        int top = n;
        int left = m;
        int right = 0;
        int bottom = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bw[i].charAt(j) == 'B') {
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    bottom = Math.max(bottom, i);
                    right = Math.max(right, j);
                }
            }
        }
        int d = Math.max(bottom - top + 1, right - left + 1);
        if (bottom - top > right - left) {

        }

    }
}
