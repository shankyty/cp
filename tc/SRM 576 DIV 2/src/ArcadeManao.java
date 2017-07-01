import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class ArcadeManao {

    int w, h, L;
    boolean[][] visited;
    String[] level;

    // A recursive implementation of a DFS.
    void dfs(int i, int j) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        // Edge: horizontal move left
        if ((j > 0) && (level[i].charAt(j - 1) == 'X')) {
            dfs(i, j - 1);
        }
        // Edge: horizontal move right
        if ((j < w - 1) && (level[i].charAt(j + 1) == 'X')) {
            dfs(i, j + 1);
        }
        // Edges: vertical moves
        for (int y = 0; y < h; y++) {
            if (abs(y - i) <= L && (level[y].charAt(j) == 'X')) {
                dfs(y, j);
            }
        }
    }

    public int shortestLadder(String[] level, int coinRow, int coinColumn) {
        h = level.length;
        w = level[0].length();
        this.level = level;
        // For each possible length:
        for (L = 0; L < 49; L++) {
            visited = new boolean[50][50];
            // Call the DFS:
            dfs(h - 1, 0);
            if (visited[coinRow - 1][coinColumn - 1]) {
                // We could reach the coin, length is good enough.
                return L;
            }
        }
        // 49 is always a valid length:
        return 49;
    }
}
