package io.shashanktyagi;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long m = in.nextInt();
        long b = in.nextInt();
        long X = b * m;
        long res = 0;
        for (long x = 0; x <= X; x++) {
            long y = b - x / m;
            if (y * m == b * m - x) {
                res = Math.max(res, (x + 1) * ((y * (y + 1)) / 2) + (y + 1) * ((x * (x + 1)) / 2));
            }
        }
        out.write(Long.toString(res));
    }
}
