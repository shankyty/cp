public class CirclesCountry {

    public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {
        int cnt = 0;
        for (int i = 0; i < X.length; i++) {
            boolean f = inside(x1, y1, X[i], Y[i], R[i]);
            boolean s = inside(x2, y2, X[i], Y[i], R[i]);
            if (f != s)
                cnt++;
        }
        return cnt;
    }

    boolean inside(int x, int y, int x1, int y1, int r) {
        return (r * r > ((y - y1) * (y - y1) + (x - x1) * (x - x1)));
    }
}
