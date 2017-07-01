import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class TreeAndVertex {

    public int get(int[] tree) {
        int[] degree = new int[tree.length];
        for (int i = 0; i < tree.length; i++) {
            degree[tree[i]]++;
        }
        for (int i = 1; i < tree.length; i++) {
            if (degree[i] != 0)
                degree[i]++;
        }
        return Arrays.stream(degree).max().getAsInt();
    }
}
