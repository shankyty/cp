package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class LongestParenthesesSubstring {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.nextLine();
        out.write(Integer.toString(longestSubstring(s)));
    }

    int longestSubstring(String data) {
        int N = data.length();
        int start = -1;
        int len = 0;
        Stack<Integer> tracker = new Stack<>();
        if (N > 1) {
            for (int i = 0; i < N; i++) {
                if ('(' == data.charAt(i)) {
                    tracker.push(i);
                } else {
                    if (tracker.empty()) {
                        start = i;
                    } else {
                        tracker.pop();
                        if (tracker.isEmpty()) {
                            len = Math.max(len, i - start);
                        } else {
                            len = Math.max(len, i - tracker.peek());
                        }
                    }
                }
            }
        }
        return len;
    }
}
