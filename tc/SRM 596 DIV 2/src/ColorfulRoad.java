import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class ColorfulRoad {

  int[] energy;

  public int getMin(String road) {
    int n = road.length();

    energy = new int[n];
    for (int i = 1; i < energy.length; i++) {
      energy[i] = -1;
    }
    for (int i = 0; i < energy.length; i++) {
      char next = "RGB".charAt(("RGB".indexOf(road.charAt(i)) + 1) % 3);
      if (energy[i] != -1) {
        for (int j = i + 1; j < energy.length; j++) {
          if (road.charAt(j) == next) {
            if (energy[j] == -1) {
              energy[j] = (j - i) * (j - i) + energy[i];
            } else {
              energy[j] = Math.min((j - i) * (j - i) + energy[i], energy[j]);
            }
          }
        }
      }
    }
    return energy[n - 1];
  }
}
