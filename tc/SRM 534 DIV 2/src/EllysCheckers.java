import java.util.Arrays;

public class EllysCheckers {

  private int[] dp = new int[1 << 21];

  String getWinner(String board) {
    int curr = 0;
    for (int i = board.length() - 1; i >= 0; i--) {
      curr = curr | ((board.charAt(i) == 'o') ? 1 << (board.length() - i - 1) : 0);
    }
    Arrays.fill(dp, -1);
    return solve(curr, 0, board.length()) ? "YES" : "NO";
  }

  private boolean solve(int curr, int p, int n) {
    System.out.println("curr = " + Integer.toBinaryString(curr));
    if (curr == 1) {
      dp[curr] = p;
    } else {
      if ((curr & 1) == 1) {
        curr = curr >> 1;
      }
      if (dp[curr] != p || dp[curr] != 2 && curr > 0) {
        for (int i = 0; i < n; i++) {
          if (checkMoves(curr, i, 1)) {
            if (solve(move(curr, i, 1), p ^ 1, n)) {
              dp[curr] = p;
              break;
            }
          }
          if (checkMoves(curr, i, 3) && !checkMoves(curr, i, 2) && !checkMoves(curr, i, 1)) {
            if (solve(move(curr, i, 3), p ^ 1, n)) {
              dp[curr] = p;
              break;
            }
          }
        }
        if (dp[curr] == -1)
          dp[curr] = p ^ 1;
      }
    }
    return dp[curr] == p;
  }

  private boolean checkMoves(int boardState, int i, int step) {
    return ((boardState & 1 << i) > 0) && (i - step >= 0 && (boardState & 1 << (i - step)) == 0);
  }

  private int move(int boardState, int i, int step) {
    return (boardState & ~(1 << i)) | 1 << i - step;
  }
}
