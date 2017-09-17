package io.shashanktyagi;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int m = Math.min(a, b);
        BigInteger res = BigInteger.ONE;
        while (m > 0) {
            res = res.multiply(new BigInteger(m + ""));
            m--;
        }
        out.write(res.toString());
    }
}
