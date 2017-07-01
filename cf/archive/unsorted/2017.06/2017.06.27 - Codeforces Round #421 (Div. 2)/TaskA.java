package io.shashanktyagi;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int c = in.nextInt();
        int v0 = in.nextInt();
        int v1 = in.nextInt();
        int a = in.nextInt();
        int l = in.nextInt();
        if (c <= v0) {
            out.write("1");
            return;
        }
        int days = 1, i = 1;
        c -= v0;
        for (; c >= (i * a + v0) && (i * a + v0 + l) <= v1; i++, days++) {
            c = c - (i * a + v0) + l;
        }
        if (v1 >= (i * a + v0 + l)) {
            v1 = i * a + v0 + l;
        }
        for (; c >= v1 - l; i++, days++) {
            c = c - v1 + l;
        }
        out.write(Integer.toString(days + ((c < 1) ? 0 : 1)));
    }

    public static void main(String[] args) {
        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();
        X.add(4);
        X.add(8);
        X.add(-7);
        X.add(-5);
        X.add(-13);
        X.add(9);
        X.add(-7);
        X.add(8);
        Y.add(4);
        Y.add(-15);
        Y.add(-10);
        Y.add(-3);
        Y.add(-13);
        Y.add(12);
        Y.add(8);
        Y.add(-8);
        System.out.println(coverPoints(X, Y));
        System.out.println("1212".compareTo("12112"));
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int s = 0;
        int e = 0;
        long max = 0;
        long cr = 0;
        int j = 0;
        while (s < a.size() && a.get(s) < 0) {
            s++;
        }
        if (s >= a.size()) {
            return new ArrayList<>();
        }
        e = j = s;
        cr = max = a.get(s);
        for (int i = s + 1; i < a.size(); i++) {
            if (a.get(i) < 0) {
                cr = 0;
                j = i + 1;
            } else {
                cr += a.get(i);
            }
            if (max < cr) {
                max = cr;
                s = j;
                e = i;
            } else if (max == cr && i - j > e - s) {
                s = j;
                e = i;
            }
        }
        Collections.sort(a);
        return new ArrayList<>(a.subList(s, e + 1));
    }

    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int n = X.size() - 1;
        int steps = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(Math.abs(X.get(i + 1) - X.get(i)), Math.abs(Y.get(i + 1) - Y.get(i)));
            int dirX = X.get(i + 1) - X.get(i) > 0 ? 1 : -1;
            int dirY = Y.get(i + 1) - Y.get(i) > 0 ? 1 : -1;
            int x = dirX * min + X.get(i);
            int y = dirY * min + Y.get(i);
            min += Math.max(Math.abs(Y.get(i + 1) - y), Math.abs(X.get(i + 1) - x));
            steps += min;
        }
        return steps;
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        newInterval.start = Math.min(newInterval.start, newInterval.end);
        newInterval.end = Math.max(newInterval.start, newInterval.end);
        ArrayList<Interval> res = new ArrayList<>();
        while (i < intervals.size() && newInterval.start <= intervals.get(i).end) {
            res.add(intervals.get(i));
            i++;
        }
        newInterval.start = intervals.get(i).start;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            i++;
        }
        if (i < intervals.size())
            newInterval.end = intervals.get(i).end;
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        //Collections.sort(res);

        return res;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static String largestNumber(final List<Integer> a) {
        ArrayList<String> string = new ArrayList<>();
        boolean isZero = true;
        for (int i = 0; i < a.size(); i++) {
            string.add(Integer.toString(a.get(i)));
            isZero = a.get(i) == 0;
        }
        Collections.sort(string, (s1, s2) -> {
            if (s1.startsWith(s2)) {
                return -1;
            } else if (s1.startsWith(s2)) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.size(); i++) {
            sb.append(string.get(i));
        }
        return isZero ? "0" : sb.toString();
    }
}
