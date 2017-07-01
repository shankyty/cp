import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class Fragile2 {

    public int countPairs(String[] graph) {
        int pairs = 0;
        int cnt = countTree(graph, -1, -1);
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph.length; j++) {
                if (countTree(graph, i, j) > cnt) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    private int countTree(String[] graph, int i, int j) {
        Set<Integer> visited = new HashSet<>();
        int cnt = 0;
        for (int k = 0; k < graph.length; k++) {
            if (k != i && k != j && !visited.contains(k)) {
                cnt++;
                dfs(k, graph, visited, i, j);
            }
        }
        return cnt;
    }

    private void dfs(int cur, String[] graph, Set<Integer> visited, int i, int j) {
        if (!visited.contains(cur)) {
            visited.add(cur);
            for (int k = 0; k < graph.length; k++) {
                if (k != i && k != j && graph[cur].charAt(k) == 'Y') {
                    dfs(k, graph, visited, i, j);
                }
            }
        }
    }
}
