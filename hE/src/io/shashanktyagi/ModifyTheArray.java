package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;

public class ModifyTheArray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        int I = in.nextInt();
        int J = in.nextInt();
        String[] nums = s.split(",");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < nums.length;) {
            for (int j = 0; j < I && i < nums.length; j++, i++) {
                sb.append(nums[i]).append(',');
            }
            for (int j = 0; j < J && i < nums.length; j++, i++) ;

        }
        sb.deleteCharAt(sb.length() - 1);
        out.write(sb.toString());
    }
}
