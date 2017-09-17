package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        long d = (n / 2) / (k + 1);
        long c = k * d;
        long l = n - d - c;
        out.write(Long.toString(d));
        out.write(" ");
        out.write(Long.toString(c));
        out.write(" ");
        out.write(Long.toString(l));
    }
}
