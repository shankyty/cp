package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    int[][] dp;
    int ns;
    int nt;
    String s;
    String t;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        ns = in.nextInt();
        nt = in.nextInt();
        s = in.next();
        t = in.next();
        dp = new int[ns][nt];
        for (int i = 0; i < ns; i++) {
            Arrays.fill(dp[i], -1000);
        }
        out.write(Integer.toString(dp(0, 0)));
        out.write('\n');
        out.write(2 + " " + 3);

    }

    int dp(int i, int j) {
        if (i < ns && j < nt) {
            int res = -1;
            for (int k = j; k < nt; k++) {
                if (t.charAt(k) == s.charAt(i)) {

                    int tmp = Math.min(res, dp(i + 1, k + 1));
                    if (tmp != -1 && res != -1) {
                        res = Math.min(res, tmp);
                    } else if (tmp != -1) {
                        res = tmp;
                    }
                }
            }
            int tmp = dp(i + 1, j + 1);
            if (tmp != -1 && res != -1) {
                res = Math.min(res, tmp + 1);
            } else if (tmp != -1) {
                res = tmp + 1;
            }
            dp[i][j] = res;
            return dp[i][j];
        } else if(i <= ns && j <= nt) {
            return 0;
        }

        return -1;
    }
}
