import java.util.*;

public class CollectingRiders {

    private int[][] steps;
    private boolean[][] visited;
    private int N, M;
    private int[] dx = new int[]{1, 1, -1, -1, 2, -2, 2, -2};
    private int[] dy = new int[]{2, -2, 2, -2, 1, -1, -1, 1};

    public int minimalMoves(String[] board) {
        N = board.length;
        M = board[0].length();
        steps = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(steps[i], -1);
        }
        List<Integer> knights = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ('.' != board[i].charAt(j)) {
                    bfs(i, j, board[i].charAt(j) - '0');
                    for (Integer knight :
                            knights) {
                        if (!visited[knight / 100][knight % 100]) {
                            return -1;
                        }
                    }
                    knights.add(i * 100 + j);
                }
            }
        }
        if (knights.size() == 1)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (steps[i][j] != -1)
                    min = Math.min(min, steps[i][j]);
            }
        }
        return min;
    }

    private void bfs(int i, int j, int k) {
        int dist = 0;
        for (int p = 0; p < N; p++) {
            Arrays.fill(visited[p], false);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(encode(i, j, dist));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int[] a = decode(q.remove());
            for (int l = 0; l < 8; l++) {
                int ni = a[0] + dx[l];
                int nj = a[1] + dy[l];
                if (rangeCheck(ni, 0, N - 1) && rangeCheck(nj, 0, M - 1) && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if (steps[ni][nj] == -1) {
                        steps[ni][nj] = 0;
                    }
                    steps[ni][nj] += (((a[2] + 1) / k) + (((a[2] + 1) % k == 0) ? 0 : 1));
                    q.add(encode(ni, nj, a[2] + 1));
                }
            }
        }
    }

    private int encode(int i, int j, int k) {
        return i * 10000 + j * 100 + k;
    }

    private int[] decode(int i) {
        return new int[]{i / 10000, (i % 10000) / 100, i % 100};
    }

    private boolean rangeCheck(int i, int l, int h) {
        return l <= i && i <= h;
    }

}
