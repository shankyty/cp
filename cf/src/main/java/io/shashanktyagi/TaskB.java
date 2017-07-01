package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] l = new int[m];
        int[] a = new int[n + 1];
        int[] f = new int[n + 1];
        for (int i = 0; i < m; i++) {
            l[i] = in.nextInt();
        }
        for (int i = 0; i < m - 1; i++) {
            int tmp = l[(i + 1) % m] - l[i];
            if (tmp <= 0) {
                tmp = l[(i + 1) % m] + n - l[i];
            }
            if (tmp == 0) {
                out.write("-1");
                return;
            }
            if (a[l[i]] != 0 && a[l[i]] != tmp) {
                out.write("-1");
                return;
            }
            a[l[i]] = tmp;
            a[l[i]] %= (n + 1);
        }
        Set<Integer> s = new HashSet<>();
        boolean isVacant = false;
        for (int i = 1; i <= n; i++) {
            isVacant |= a[i] == 0;
            if (a[i] != 0)
                s.add(a[i]);
        }
        if (isVacant) {
            for (int i = 1, j = 1; i <= n && j <= n; ) {
                while (i <= n && s.contains(i)) {
                    i++;
                }
                if (i <= n) {
                    while (j <= n && a[j] != 0) {
                        j++;
                    }
                    if (j <= n) {
                        a[j] = i;
                        s.add(i);
                    }
                }
            }
        }
        if (s.size() != n) {
            out.write("-1");
        } else {
            boolean isValid = true;
            for (int i = 1; i <= n; i++) {
                isValid &= s.contains(i);
            }
            if (isValid) {
                for (int i = 1; i <= n; i++) {
                    out.write(Integer.toString(a[i]) + " ");
                }
            } else {
                out.write("-1");
            }
        }


    }
}
