import java.util.Arrays;

public class LuckyCycle {

    int[][] adj;
    private int[][] sevens;
    private int[][] four;

    public int[] getEdge(int[] edge1, int[] edge2, int[] weight) {
        int N = edge1.length;
        adj = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(adj[i], 10000);
        }
        four = new int[N + 1][N + 1];
        sevens = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            adj[edge2[i] - 1][edge1[i] - 1] = adj[edge1[i] - 1][edge2[i] - 1] = 1;
            if (weight[i] == 7)
                sevens[edge2[i] - 1][edge1[i] - 1] = sevens[edge1[i] - 1][edge2[i] - 1] = 1;
            else
                four[edge2[i] - 1][edge1[i] - 1] = four[edge1[i] - 1][edge2[i] - 1] = 1;
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= N; k++) {
                    if (i != j && adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                        sevens[i][j] = sevens[i][k] + sevens[k][j];
                        four[i][j] = four[i][k] + four[k][j];
                    }
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (adj[i][j] % 2 == 1 && (four[i][j] + sevens[i][j] > 1) && ((four[i][j] == sevens[i][j] + 1) || (four[i][j] + 1 == sevens[i][j]))) {
                    if (four[i][j] < sevens[i][j])
                        return new int[]{i + 1, j + 1, 4};
                    if (four[i][j] > sevens[i][j])
                        return new int[]{i + 1, j + 1, 7};
                }
            }
        }
        return new int[]{};
    }
}
