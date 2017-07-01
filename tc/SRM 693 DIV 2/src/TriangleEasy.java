
public class TriangleEasy {


    public int find(int n, int[] x, int[] y) {
        boolean[][] aM = new boolean[n][n];
        for (int i = 0; i < x.length; i++) {
            aM[x[i]][y[i]] = aM[y[i]][x[i]] = true;
        }
        if (x.length == 1) {
            return 2;
        }
        int cnt = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (i != j) {
                    if ((x[i] == x[j] && aM[y[i]][y[j]])
                            || (x[i] == y[j] && aM[y[i]][x[j]])
                            || (y[i] == y[j] && aM[x[i]][x[j]])) {
                        cnt = 3;
                        break;
                    } else if (x[i] == x[j]
                            || x[i] == y[j]
                            || y[i] == y[j]) {
                        cnt = Math.max(2, cnt);
                    } else {
                        cnt = Math.max(1, cnt);
                    }
                }
            }
        }
        return 3 - cnt;
    }
}
