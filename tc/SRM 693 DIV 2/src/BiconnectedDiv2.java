import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class BiconnectedDiv2 {

    public int minimize(int[] w1, int[] w2) {
        int a = 0;
        int s = 0;
        for (int i = 1; i < w1.length - 1; i++) {
            a += (w1[i] >= 0) ? w1[i] : 0;
        }
        for (int i = 0; i < w1.length; i++) {
            s += w1[i];
        }
        for (int i = 0; i < w2.length; i++) {
            s += w2[i];
        }
        return s - a;
    }
}