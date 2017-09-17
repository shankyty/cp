package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        String s = in.next();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            } else {
                sb.append(cnt);
                cnt = 0;
            }

        }
        sb.append(cnt);
        out.write(sb.toString());
    }
}
