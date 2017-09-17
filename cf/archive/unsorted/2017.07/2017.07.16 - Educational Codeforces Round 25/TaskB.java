package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char[][] x = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String l = in.next();
            for (int j = 0; j < 10; j++) {
                x[i][j] = l.charAt(j);
            }
        }
        String[] s = "0001".split("0");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (checkH(x, i, j) || checkD(x, i, j) || checkV(x, i, j) || checkOD(x, i, j)) {
                    out.write("YES");
                    return;
                }
            }
        }
        out.write("NO");
    }

    boolean checkH(char[][] x, int i, int j) {
        if (j > 5) return false;
        int e = 0;
        int xc = 0;
        for (int k = j; k < j + 5; k++) {
            if (x[i][k] == 'X') {
                xc++;
            } else if (x[i][k] == '.') {
                e++;
            } else {
                return false;
            }
        }
        return xc == 4 && e == 1;
    }

    boolean checkV(char[][] x, int i, int j) {
        if (i > 5) return false;
        int e = 0;
        int xc = 0;
        for (int k = i; k < i + 5; k++) {
            if (x[k][j] == 'X') {
                xc++;
            } else if (x[k][j] == '.') {
                e++;
            } else {
                return false;
            }
        }
        return xc == 4 && e == 1;
    }

    boolean checkD(char[][] x, int i, int j) {
        if (i > 5 || j > 5) return false;
        int e = 0;
        int xc = 0;
        for (int k = 0; k < 5; k++) {
            if (x[i + k][j + k] == 'X') {
                xc++;
            } else if (x[i + k][j + k] == '.') {
                e++;
            } else {
                return false;
            }
        }
        return xc == 4 && e == 1;
    }

    boolean checkOD(char[][] x, int i, int j) {
        if (i < 4 || j > 5) return false;
        int e = 0;
        int xc = 0;
        for (int k = 0; k < 5; k++) {
            if (x[i - k][j + k] == 'X') {
                xc++;
            } else if (x[i - k][j + k] == '.') {
                e++;
            } else {
                return false;
            }
        }
        return xc == 4 && e == 1;
    }
}
