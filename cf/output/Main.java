import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author shanky_ty
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            String colors = in.next().toLowerCase();
            int[] s = new int[26];
            for (int i = 0; i < n; i++) {
                s[colors.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length; i++) {
                if (s[i] % 2 == 1) {
                    out.write("NO");
                    return;
                }
            }
            out.write("YES");
        }

    }
}

