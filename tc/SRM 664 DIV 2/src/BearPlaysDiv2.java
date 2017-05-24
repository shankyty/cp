import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class BearPlaysDiv2 {

  private HashSet<Integer> dp;

  private int[][] moves = new int[][]{
      {0, 1},
      {0, 2},
      {1, 2}
  };

  public String equalPiles(int A, int B, int C) {
    if ((A + B + C) % 3 != 0)
      return "impossible";
    if (A == B && B == C)
      return "possible";
    int K = (A + B + C) / 3;
    dp = new HashSet<>();
    ArrayDeque<int[]> q = new ArrayDeque<>();
    q.add(new int[]{A, B, C});
    dp.add(Arrays.hashCode(q.peekFirst()));
    while (!q.isEmpty()) {
      int[] cur = q.remove();
      for (int i = 0; i < moves.length; i++) {
        int[] next = Arrays.copyOf(cur, 3);
        if (next[moves[i][0]] > next[moves[i][1]]) {
          next[moves[i][0]] -= next[moves[i][1]];
          next[moves[i][1]] = 2 * next[moves[i][1]];
        } else {
          next[moves[i][1]] -= next[moves[i][0]];
          next[moves[i][0]] = 2 * next[moves[i][0]];
        }
        if (next[0] == next[1] && next[1] == next[2])
          return "possible";

        if (next[0] > 0 && next[1] > 0 && next[2] > 0 && !dp.contains(Arrays.hashCode(next))) {
          dp.add(Arrays.hashCode(next));
          q.add(next);
        }
      }
    }
    return "impossible";
  }
}
