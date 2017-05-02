import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class FoxAndSightseeing {

  public int getMin(int[] position) {
    int dist = 0;
    for (int i = 1; i < position.length; i++) {
      dist += Math.abs(position[i] - position[i - 1]);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < position.length - 1; i++) {
      min = Math.min(min,
          dist - Math.abs(position[i] - position[i - 1]) - Math.abs(position[i + 1] - position[i]) + Math.abs(position[i + 1] - position[i - 1])
      );
    }
    return min;
  }
}
