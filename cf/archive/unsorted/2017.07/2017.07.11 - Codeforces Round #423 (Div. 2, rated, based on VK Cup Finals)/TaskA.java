package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int g = in.nextInt();
            if (g == 1) {
                if (a > 0) {
                    a--;
                } else if(b > 0) {
                    b--;
                    c++;
                } else if(c > 0){
                    c--;
                } else {
                    res+=g;
                }
            } else if(g == 2){
                if(b > 0) {
                    b--;
                } else {
                    res+=g;
                }
            }
        }
        out.write(Integer.toString(res));
    }
}
