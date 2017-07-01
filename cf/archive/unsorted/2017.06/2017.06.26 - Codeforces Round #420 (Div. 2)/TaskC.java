package io.shashanktyagi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int N = in.nextInt();
        List<Integer> ls = new ArrayList<>(N);
        int r = 0;
        int rorder = 0;
        for (int i = 0; i < N * 2; i++) {
            String command = in.next();
            if ("remove".equals(command)) {
                r++;
                if (ls.get(ls.size() - 1) != r) {
                    rorder++;
                    ls.sort(Collections.reverseOrder());
                }
                ls.remove(ls.size() - 1);
            } else {
                ls.add(in.nextInt());
            }
        }
        out.write(Integer.toString(rorder));
    }
}
