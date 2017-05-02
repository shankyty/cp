import java.util.Arrays;

public class NumberofFiboCalls {

  public int[] fiboCallsMade(int n) {
    if (n == 0) return new int[]{1, 0};
    if (n == 1) return new int[]{0, 1};
    int[] ones = new int[n + 1];
    int[] zeores = new int[n + 1];
    ones[1] = 1;
    zeores[0] = 1;
    for (int i = 2; i <= n; i++) {
      ones[i] = ones[i - 1] + ones[i - 2];
      zeores[i] = zeores[i - 1] + zeores[i - 2];
    }
    System.out.println(Arrays.toString(ones));
    System.out.println(Arrays.toString(zeores));
    return new int[]{zeores[n], ones[n]};
  }
}
