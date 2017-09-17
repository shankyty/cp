package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        ArrayList<Integer> as = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            as.add(in.nextInt());
        }
        as.sort(Integer::compare);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (as.get(i) <= k * 2) {
                k = Math.max(k, as.get(i));
            } else {
                while (k * 2 < as.get(i)) {
                    k = k * 2;
                    cnt++;
                }
                k = as.get(i);
            }
        }
        out.write(Integer.toString(cnt));
    }
}
