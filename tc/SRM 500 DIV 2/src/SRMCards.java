import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class SRMCards {
  int[][] moves;

  public int maxTurns(int[] cards) {
    Arrays.sort(cards);
    int[] moves = new int[cards.length];
    boolean[] isremoved = new boolean[cards.length];
    int mv = 0;
    if (cards.length == 1)
      return 1;
    moves[0] = cards[0] + 1 == cards[1] ? 2 : 1;
    moves[cards.length - 1] = cards[cards.length - 2] + 1 == cards[cards.length - 1] ? 2 : 1;
    for (int i = 1; i < moves.length - 1; i++) {
      if (cards[i - 1] + 1 == cards[i] && cards[i] + 1 == cards[i + 1]) {
        moves[i] = 3;
      } else if (cards[i] + 1 == cards[i + 1] || cards[i] - 1 == cards[i - 1]) {
        moves[i] = 2;
      } else {
        moves[i] = 1;
      }
    }
    for (int i = 0; i < cards.length; i++) {
      if (!isremoved[i] && moves[i] == 1) {
        isremoved[i] = true;
        mv++;
      }
    }
    for (int i = 0; i < cards.length - 1; i++) {
      if (!isremoved[i] && moves[i] == 2) {
        if (i == 0 || moves[i - 1] != 3)
          isremoved[i + 1] = true;
        isremoved[i] = true;
        mv++;
      }
    }
    for (int i = 1; i < cards.length - 1; i++) {
      if (!isremoved[i]) {
        isremoved[i] = isremoved[i + 1] = true;
        mv++;
      }
    }
    if (!isremoved[cards.length - 1] && moves[cards.length - 1] == 2) {
      isremoved[cards.length - 1] = true;
      mv++;
    }
    return mv;
  }
}