import java.util.*;
import java.math.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class SortingGame {

    public int fewestMoves(int[] board, int k) {
        List<Integer> dest = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            int i1 = board[i];
            dest.add(i1);
        }
        List<Integer> curr = new ArrayList<>(dest);
        Collections.sort(dest);
        Queue<List<Integer>> q = new ArrayDeque<>();
        Queue<Integer> dist = new ArrayDeque<>();
        Set<List<Integer>> visited = new HashSet<>();
        visited.add(curr);
        q.add(curr);
        dist.add(0);
        int cnt = 0;
        while (!q.isEmpty() && !Objects.deepEquals(dest, curr)) {
            curr = q.remove();
            cnt = dist.remove();
            for (int i = 0; i <= board.length - k; i++) {
                List<Integer> next = reverse(new ArrayList<>(curr), k, i);
                if (!visited.contains(next)) {
                    q.add(next);
                    dist.add(cnt + 1);
                    visited.add(next);
                }
            }
        }
        return Objects.deepEquals(dest, curr) ? cnt : -1;
    }

    private List<Integer> reverse(List<Integer> source, int k, int i) {
        if (k % 2 == 1) {
            for (int j = 0; j <= k / 2; j++) {
                Collections.swap(source, i + j, i + k - j - 1);
            }
        } else {
            for (int j = 0; j < k / 2; j++) {
                Collections.swap(source, i + j, i + k - j - 1);
            }
        }
        return source;
    }
}
