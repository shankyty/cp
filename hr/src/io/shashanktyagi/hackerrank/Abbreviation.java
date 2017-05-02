package io.shashanktyagi.hackerrank;

import java.util.Scanner;
import java.io.PrintWriter;

public class Abbreviation {
  private boolean[][] possible;
  private boolean[][] visited;
  private String a;
  private String b;

  public void solve(int testNumber, Scanner in, PrintWriter out) {
    a = in.next();
    b = in.next();
    possible = new boolean[a.length()][b.length()];
    visited = new boolean[a.length()][b.length()];
    if (solve(0, 0)) {
      out.print("YES");
    } else
      out.print("YES");
    out.print('\n');
  }

  private boolean findCaps(int start, int end, String s) {
    for (int j = start + 1; j < end; j++) {
      if (Character.isUpperCase(s.charAt(j))) {
        return true;
      }
    }
    return false;
  }

  private boolean solve(int i, int j) {
    if (visited[i][j]) return possible[i][j];
    visited[i][j] = true;
    if (i == b.length())
      for (int k = j; k < a.length(); k++) {
        if (b.charAt(i) == a.charAt(j) ||
                b.charAt(i) == Character.toUpperCase(a.charAt(j))) {
          if (solve(i + 1, k)) {
            return possible[i][j] = true;
          }
        }
      }
    return possible[i][j];
  }
}
