import java.util.Arrays;

public class NoRepeatPlaylist {
  long MOD = 1000000007;

  long[][][] dp = new long[101][101][101];

  public int numPlaylists(int N, int M, int P) {
    for (long[][] square : dp) {
      for (long [] line : square) {
        Arrays.fill(line, -1);
      }
    }
    return (int)countPlaylists(0, 0, N, M, P);

  }

  long countPlaylists(int position, int XS, int YS, int M, int P) {
    if (position == P)
      return YS == 0 ? 1 : 0;
    if (dp[position][XS][YS] != -1)
      return dp[position][XS][YS];

    long result = 0;
    if (YS > 0)
      result = countPlaylists(position + 1, XS + 1, YS - 1, M, P) * YS;
    if (XS > M)
      result += countPlaylists(position + 1, XS, YS, M, P) * (XS - M);
    return dp[position][XS][YS] = result % MOD;
  }

}
