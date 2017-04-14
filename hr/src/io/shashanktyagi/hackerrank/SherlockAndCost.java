package io.shashanktyagi.hackerrank;

import java.util.Scanner;
import java.io.PrintWriter;

public class SherlockAndCost {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
        }
        int[][] s  = new int[2][2];
        for (int i = 1; i < n; i++) {
            s[i%2][0] = Math.max(s[(i-1)%2][0] ,s[(i-1)%2][1] + m[i-1] -1);
            s[i%2][1] = Math.max(s[(i-1)%2][0] + m[i] -1 ,s[(i-1)%2][1] + Math.abs(m[i] - m[i-1]));
        }
        out.print(Math.max(s[(n-1)%2][0],s[(n-1)%2][1]));
        out.print('\n');
    }
}
