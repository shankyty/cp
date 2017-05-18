import java.util.Arrays;

import static java.lang.Math.min;

public class CuttingBitString {

  int[] dp;

  public int getmin(String S) {
    dp = new int[S.length() + 1];
    Arrays.fill(dp, -1);
    int cnt = counts(S, S.length());
    return cnt;
  }

  private int counts(String S, int i) {
    if (i == 0)
      return 0;
    if (i == 1) {
      return S.charAt(0) == '1' ? 1 : -1;
    }

    int k = Integer.MAX_VALUE;
    if (dp[i] == -1) {
      for (int j = i - 1; j >= 0; j--) {
        if (S.charAt(j) != '0' && isPower(Long.parseLong(S.substring(j, i), 2))) {
          int res = counts(S, j);
          if (res == -1) {
            continue;
          }
          k = min(res + 1, k);
        }
      }
      dp[i] = k == Integer.MAX_VALUE ? -1 : k;
    }
    return dp[i];
  }

  private boolean isPower(long val) {
    while (val % 5 == 0) {
      val /= 5;
    }
    return val == 1;
  }
}