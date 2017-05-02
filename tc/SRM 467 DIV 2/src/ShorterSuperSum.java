public class ShorterSuperSum {


  public int calculate(int k, int n) {
    int[][] ssum = new int[2][n + 1];
    int flag = 1;
    for (int j = 0; j <= n; j++) {
      ssum[0][j] = j;
    }
    for (int K = 1; K <= k; K++) {
      for (int i = 1; i <= n; i++) {
        ssum[flag][i] = ssum[flag][i - 1] + ssum[flag ^ 1][i];
      }
      flag ^= 1;
    }


    return ssum[flag ^ 1][n];
  }
}
