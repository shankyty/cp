package io.shashanktyagi.hackerrank;

import java.util.Scanner;
import java.io.PrintWriter;

public class Candies {
  public void solve(int testNumber, Scanner in, PrintWriter out) {

    long ans = 0, tmp = 0;
    int[] rate = new int[100000 + 10];
    long[] values = new long[100000 + 10];
    int n = in.nextInt();

    for (int i = 0; i < n; i++) rate[i] = in.nextInt();

    values[0] = 1;
    // case 1
    for (int i = 1; i < n; i++) {

      if (rate[i] > rate[i - 1]) {

        values[i] = values[i - 1] + 1;

      } else values[i] = 1;
    }

    ans = values[n - 1];

    for (int i = n - 2; i >= 0; i--) {

      if (rate[i] > rate[i + 1]) {

        tmp = values[i + 1] + 1;

      } else tmp = 1;

      ans += Math.max(tmp, values[i]);
      values[i] = tmp;
    }
    out.print(ans);
  }
}