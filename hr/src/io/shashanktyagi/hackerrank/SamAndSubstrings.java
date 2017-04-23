package io.shashanktyagi.hackerrank;


import java.util.Scanner;
import java.io.PrintWriter;

public class SamAndSubstrings {

  public static final long MOD = 1000000007;

  public void solve(int testNumber, Scanner in, PrintWriter out) {
    String n = in.next();
    long sd;
    long ans;
    ans = sd = n.charAt(0) - '0';
    for (int i = 1; i < n.length(); i++) {
      sd = sd * 10 + (n.charAt(i) - '0') * (i + 1);
      sd =sd %MOD;
      ans = (ans + sd) % MOD;
    }
    out.print(ans);
  }
}
