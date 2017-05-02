public class EmoticonsDiv2 {

  private int[] dur;

  public int printSmiles(int smiles) {

    dur = new int[smiles + 1];
    dur[1] = 1;
    dur[2] = 2;
    int i = solve(smiles);
    return i;
  }

  private int solve(int n) {
    if (dur[n] != 0) {
      return dur[n];
    }
    dur[n] = n;
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        dur[n] = Math.min(dur[n], solve(n / i) + i);
      }

    }
    return dur[n];
  }
}
