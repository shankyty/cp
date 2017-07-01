package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class FizzBuzz {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            for (int j = 1; j <= n; j++) {
                if (j % 3 == 0 || j % 5 == 0) {
                    if (j % 3 == 0)
                        out.write("Fizz");
                    if (j % 5 == 0)
                        out.write("Buzz");
                } else {
                    out.write(Integer.toString(j));
                }
                out.write("\n");
            }
        }
    }
}
