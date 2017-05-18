import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.Scanner;
import java.util.Stack;

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
    private static Stack<Long> stack = new Stack<>();

    public void solve(int testNumber, Scanner in, PrintWriter out) {

      String s = in.next();
      switch (s) {
        case "push":
          stack.push(in.nextLong());
          break;
        case "pop":
          if (!stack.isEmpty())
            stack.pop();
          break;
        case "inc":
          Long x = in.nextLong();
          Long d = in.nextLong();
          for (int i = 0; i < Math.min(x, stack.size()); i++) {
            stack.set(i, stack.get(i) + d);
          }
      }
      if (stack.isEmpty()) {
        out.print("EMPTY");
      } else {
        out.print(stack.peek());
      }
      out.print('\n');

    }

  }
}

