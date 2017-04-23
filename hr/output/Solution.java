import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger;

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
    FibonacciModified solver = new FibonacciModified();
    solver.solve(1, in, out);
    out.close();
  }

  static class FibonacciModified {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
      BigInteger a = BigInteger.valueOf(in.nextLong());
      BigInteger b = BigInteger.valueOf(in.nextLong());
      int n = in.nextInt();
      for (int i = 3; i <= n; i++) {
        if (i % 2 == 1) {
          a = a.add(b.pow(2));
        } else {
          b = b.add(a.pow(2));
        }
      }
      if (n % 2 == 1) {
        out.print(a);
      } else {
        out.print(b);
      }
    }

  }
}

