package io.shashanktyagi.hackerrank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class VerticalSticks {
  public void solve(int testNumber, Scanner in, PrintWriter out) {
    int n = in.nextInt();
    int[] nums = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      nums[i] = in.nextInt();
    }
    Arrays.sort(nums);
    double ans = 0;
    double[][] c = new double[n + 1][n + 1];
    c[0][0] = 1;
    for (int i = 0; i < n + 1; i++) {
      c[i][0] = c[i][i] = 1;
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < i; j++) {
        c[i][j] = ((i + 1 - j) * c[i][j - 1]) / j;
      }
    }
    for (int i = 1; i <= n; i++) {
      int r = i;
      while (nums[i] == nums[r]) r--;
      int greater = n - r - 1;
      int smaller = r;
      for (int p = 1; p <= n; p++) {
        for (int k = 0; k <= r && k <= p - 1; k++) {
          if (k == p - 1)
            ans += (k+1) * c[smaller][k] / (n * c[n - 1][k]);
          else
            ans += (k+1) * c[smaller][k] * greater / (n * (n - 1) * c[n - 2][k]);
        }
      }
    }
    out.print(BigDecimal.valueOf(ans).setScale(2,BigDecimal.ROUND_HALF_DOWN));
    out.print('\n');
  }
}
