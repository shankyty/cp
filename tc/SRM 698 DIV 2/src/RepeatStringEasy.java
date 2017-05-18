import static java.lang.Math.max;

public class RepeatStringEasy {

  public int maximalLength(String s) {
    int res = 0;
    int n = s.length();
    for (int i = 1; i < n; i++) {
      res = max(lcs(s.subSequence(0, i), s.subSequence(i, n)), res);
    }
    return 2 * res;
  }

  private int lcs(CharSequence a, CharSequence b) {
    int[][] dp = new int[a.length() + 1][b.length() + 1];
    for (int i = 0; i <= a.length(); i++) {
      for (int j = 0; j <= b.length(); j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (a.charAt(i - 1) == b.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[a.length()][b.length()];
  }
}