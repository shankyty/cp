package io.shashanktyagi.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class FibonacciModified {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    BigInteger a = BigInteger.valueOf(in.nextLong());
    BigInteger b = BigInteger.valueOf(in.nextLong());
    int n = in.nextInt();
    for (int i = 3; i <= n; i++) {
      if (i % 2 == 1) {
        a = a.add(b.pow(2));
      } else {
        b = b.add(a.pow(2));
      }
    }
    if (n % 2 == 1) {
      out.print(a);
    } else {
      out.print(b);
    }
  }
}
