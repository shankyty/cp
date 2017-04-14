package io.shashanktyagi.hackerrank;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Equal {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int colleagues = in.nextInt();
        int[] choclates = new int[colleagues];
        for (int i = 0; i < colleagues; i++) {
            choclates[i] = in.nextInt();
        }

        System.out.println(findMin(choclates, Arrays.stream(choclates).min().getAsInt()));

    }

    private int findMin(int[] start,int min) {
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i <= 5; i++,min--) {
            int curSteps = 0;
            for (int j = 0; j < start.length; j++) {
                int d = start[j] - min;
                curSteps += d / 5 + (d % 5) / 2 + (d % 5) % 2;
            }
            minSteps = Math.min(minSteps, curSteps);
        }
        return minSteps;
    }
}