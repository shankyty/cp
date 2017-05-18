package io.shashanktyagi.hackerrank;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class PrimeXOR {

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
