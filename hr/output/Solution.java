import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    Scanner in = new Scanner(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    PrimeXOR solver = new PrimeXOR();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class PrimeXOR {
    public static final int MOD = 1000000009;
    static boolean[] prime = new boolean[9000];

    static {
      prime[2] = true;
      for (int i = 3; i < 9000; i += 2) {
        prime[i] = true;
      }
      for (int i = 3; i * i < 9000; i += 2) {
        if (prime[i]) {
          for (int j = i * i; j <= 9000; j += 2 * i) {
            prime[j] = false;
          }
        }
      }
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
      int n = in.nextInt();
      long[] count = new long[5000];
      int[] num = new int[n];
      long[][] ways = new long[2][8195];
      int k = 0;
      for (int i = 0; i < n; i++) {
        num[i] = in.nextInt();
        if (count[num[i]] == 0) {
          k++;
        }
        count[num[i]] += 1;
      }
      //System.out.println(Arrays.toString(count));
      int curr = 1;
      ways[0][0] = 1;
      for (int i = 1; i <= k; i++) {
        for (int j = 0; j < 8192; j++) {
          ways[curr][j] = (ways[curr ^ 1][j] * (1 + count[num[i - 1]] / 2)) % MOD
                              + ways[curr ^ 1][j ^ num[i - 1]] * ((count[num[i - 1]] + 1) / 2) % MOD;
        }
        curr = curr ^ 1;
      }
      long c = 0;
      for (int i = 0; i < 8192; i++) {
        if (prime[i]) {
          c = (c + ways[curr ^ 1][i]) % MOD;
        }
      }
      out.print(c);
      out.print('\n');
    }

  }
}

