import java.util.HashMap;
import java.util.stream.IntStream;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MutaliskEasy {


  private HashMap<Integer, Integer> map = new HashMap<>();

  int[][] moves = new int[][]{
      {0, 1, 2},
      {0, 2, 1},
      {1, 0, 2},
      {1, 2, 0},
      {2, 0, 1},
      {2, 1, 0}};

  public int minimalAttacks(int[] x) {
    switch (x.length) {
      case 1:
        x = new int[]{x[0], 0, 0};
        break;
      case 2:
        x = new int[]{x[0], x[1], 0};
        break;
    }
    return solve(x);
  }

  int solve(int[] x) {
    if (IntStream.of(x).filter(i -> i > 0).count() == 0) {
      return 0;
    }
    int move;
    if (!map.containsKey(getKey(x))) {
      move = 62;
      for (int i = 0; i < 6; i++) {
        int[] tx = new int[3];
        tx[moves[i][0]] = max(x[moves[i][0]] - 9, 0);
        tx[moves[i][1]] = max(x[moves[i][1]] - 3, 0);
        tx[moves[i][2]] = max(x[moves[i][2]] - 1, 0);
        move = min(solve(tx) + 1, move);
      }
      map.put(getKey(x), move);
    }
    return map.get(getKey(x));
  }

  int getKey(int[] hp) {
    return hp[0] * 10000 + hp[1] * 100 + hp[2];
  }
}
