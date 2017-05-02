public class NumbersChallenge {

  private boolean[] poss;

  public int MinNumber(int[] S) {
    int n = S.length;
    poss = new boolean[100000 * n + 1];
    for (int mask = 0; mask < (1 << n); mask++) {
      int sum = 0;
      for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) > 0) {
          sum += S[i];
        }
      }
      poss[sum] = true;
    }
    int x = 1;
    while (poss[x]) {
      x++;
    }
    return x;
  }
}
