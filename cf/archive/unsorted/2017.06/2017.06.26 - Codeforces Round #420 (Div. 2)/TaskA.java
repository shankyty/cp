package io.shashanktyagi;

import java.util.Scanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int N = in.nextInt();
        int[][] lab = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                lab[i][j] = in.nextInt();
            }
        }
        boolean res = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] > 1)
                    res = isGood(lab, i, j);
                if (!res) {
                    out.write("No");
                    return;
                }

            }
        }
        out.write(res ? "Yes" : "No");
    }

    boolean isGood(int[][] lab, int i, int j) {
        for (int k = 0; k < lab.length; k++) {
            for (int l = 0; l < lab[0].length; l++) {
                if (lab[i][j] == lab[i][k] + lab[l][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
