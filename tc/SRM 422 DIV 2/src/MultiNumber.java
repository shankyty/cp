import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class MultiNumber {

  public String check(int number) {
    if (number < 10)
      return "NO";
    String s = Integer.toString(number);

    for (int i = 0; i < s.length(); i++) {
      if (mul(s, 0, i) == mul(s, i + 1, s.length() - 1))
        return "YES";
    }
    return "NO";
  }

  private int mul(String s, int i, int j) {
    System.out.println(s);
    int res = 1;
    for (int idx = i; idx <= j; idx++) {
      System.out.println((s.charAt(idx) - '0'));
      res *= (s.charAt(idx) - '0');
    }
    return res;
  }
}
