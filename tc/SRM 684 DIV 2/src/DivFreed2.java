import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivFreed2 {
  private static int MOD = 1000000007;
  int[][] data;
  List<List<Integer>> divs;

  public int count(int n, int k) {
    data = new int[2][k + 1];
    divs = new ArrayList<>();
    Arrays.fill(data[0], 1);
    for (int i = 1; i <= k; i++) {
      divs.add(new ArrayList<>());
      for (int j = 2 * i; j <= k; j += i) {
        divs.get(i - 1).add(j);
      }
    }
    int flag = 1;
    for (int i = 2; i <= n; i++) {
      int sum = 0;
      for (int j = 1; j <= k; j++) {
        sum = (sum + data[flag ^ 1][j]) % MOD;
      }
      for (int j = 1; j <= k; j++) {
        data[flag][j] = sum;
        for (Integer div : divs.get(j - 1)) {
          data[flag][j] = (data[flag][j] + MOD - data[flag ^ 1][div]) % MOD;
        }
      }
      flag ^= 1;
    }
    int res = 0;
    for (int i = 1; i <= k; i++) {
      res = (res + data[flag ^ 1][i]) % MOD;
    }
    return res;
  }
}