import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class ThePalindrome {


  public int find(String s) {
    int n = s.length();
    int i = 0;
    for (; i < n; i++) {
      if (isPalindrome(s, i, n - 1)) break;
    }
    return n + i;
  }

  private boolean isPalindrome(String s, int i, int j) {
    while (i < j && s.charAt(i) == s.charAt(j)) {
      i++;
      j--;
    }
    return i >= j;
  }
}
