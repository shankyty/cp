import java.util.Arrays;

public class JumpDistancesOnTreeEasy {

    public String isPossible(int[] p, int[] S) {
        int[][] d = new int[p.length][p.length];
        for (int i = 0; i < p.length; i++) {
            Arrays.fill(d[i], 10000);
        }
        for (int i = 0; i < p.length; i++) {
            d[i][p[i]] = d[p[i]][i] = 1;
        }
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                for (int k = 0; k < p.length; k++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        int[][] dp = new int[S.length][p.length];
        for (int i = 0; i < S.length; i++) {

        }
        return null;
    }
}
