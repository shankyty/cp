import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PathGameDiv2 {

    int[][] blacks = new int[2][50];
    boolean[][] visited = new boolean[2][50];

    public int calc(String[] board) {
        for (int i = 1; i < board.length; i++) {
            Arrays.fill(blacks[i], -1);
            Arrays.fill(visited[i], false);
        }
        return 0;
    }

    void bfs(String[] board, int i, int j) {
        Queue<Integer> p = new ArrayDeque<>();
        p.add(encodeNode(i, j, 0));
        while (!p.isEmpty()) {
            int crypt = p.remove();
            int[] node = decodeNode(crypt);
            if (!visited[node[0]][node[1]] || ) {
            }
        }
    }

    int[] decodeNode(int crypt) {
        return new int[]{(crypt / 100) % 10000, crypt % 100, crypt / 10000};
    }

    int encodeNode(int i, int j, int d) {
        return d * 10000 + i * 100 + j;
    }

}
