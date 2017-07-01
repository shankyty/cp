import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ModifyTheArray solver = new ModifyTheArray();
        solver.solve(1, in, out);
        out.close();
    }

    static class ModifyTheArray {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.nextLine();
            int I = in.nextInt();
            int J = in.nextInt();
            String[] nums = s.split(",");
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0; i < nums.length; ) {
                for (int j = 0; j < I && i < nums.length; j++, i++) {
                    sb.append(nums[i]).append(',');
                }
                for (int j = 0; j < J && i < nums.length; j++, i++) ;

            }
            sb.deleteCharAt(sb.length() - 1);
            out.write(sb.toString());
        }

    }
}

