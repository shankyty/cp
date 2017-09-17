package io.shashanktyagi.hackerrank;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SuperMancunian {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] graph = new int[n][n];
        for (int a0 = 0; a0 < m; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int w = in.nextInt();
            graph[a - 1][b - 1] = w;
        }

        double visited[][] = new double[n][2];
        double cnt[] = new double[n];
        int k = 1;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(visited[i], Double.MAX_VALUE);
        }

        cnt[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited[0][k] = 0.0;
        pq.add(new Node(0, 0, k));
        double res = Double.MAX_VALUE;
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            if (visited[top.index][top.magic] < top.dist) {
                continue;
            }

            for (int i = 0; i < n; ++i) {
                if (i == top.index) continue;

                if (top.magic >= 1) {
                    double distance = top.dist;
                    if (distance < visited[i][top.magic - 1]) {
                        pq.add(new Node(i, distance, top.magic - 1));
                        visited[i][top.magic - 1] = distance;
                        cnt[i] = cnt[top.index] + 1;
                    }
                }

                double distance = top.dist + (double) graph[top.index][i];
                if (distance < visited[i][top.magic]) {
                    pq.add(new Node(i, distance, top.magic));
                    visited[i][top.magic] = distance;
                    cnt[i] = cnt[top.index] + 1;
                }
            }
        }

        for (int i = 0; i <= k; ++i) {
            if (cnt[i] == n - 1) {
                res = Math.min(res, visited[1][i]);
            }
        }
        out.write(res + " " + res);
    }

    static class Node implements Comparable<Node> {
        int index;
        double dist;
        int magic;

        public Node(int index, double dist, int magic) {
            this.index = index;
            this.dist = dist;
            this.magic = magic;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist < o.dist)
                return -1;
            else if (this.dist > o.dist)
                return 1;
            return 0;
        }

    }
}
