package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String colors = in.next().toLowerCase();
        int[] s = new int[26];
        for (int i = 0; i < n; i++) {
            s[colors.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] % 2 == 1) {
                out.write("NO");
                return;
            }
        }
        out.write("YES");
    }
}
