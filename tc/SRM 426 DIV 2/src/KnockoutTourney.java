import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class KnockoutTourney {

  public int meetRival(int N, int you, int rival) {
    int rounds = 0;
    while (you != rival) {
      rival = rival / 2 + rival % 2;
      you = you / 2 + you % 2;
      rounds++;
    }
    return rounds;
  }
}
