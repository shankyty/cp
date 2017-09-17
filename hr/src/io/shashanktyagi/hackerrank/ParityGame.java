package io.shashanktyagi.hackerrank;

import java.io.PrintWriter;
import java.util.Scanner;

public class ParityGame {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        int o = -1;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
            if (o == -1 && a[i] % 2 == 1) {
                o = i;
            }
        }
        if (sum % 2 == 1) {
            if (n == 1) {
                out.write("-1");
            } else if (o > -1) {
                out.write("1");
            } else {
                out.write("-1");
            }
        } else {
            out.write("0");
        }
    }
}
