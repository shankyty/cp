import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DoubleWeights {

    boolean[] visisted = new boolean[21];
    private int res = Integer.MAX_VALUE;
    private String[] weight2;
    private String[] weight1;
    private int w2;
    private int w1;


    public int minimalCost(String[] weight1, String[] weight2) {
        this.weight1 = weight2;
        this.weight2 = weight1;
        res = dijkstra(0);
        return res == 100000000 ? -1 : res;
    }

    int dijkstra(int src) {
        int[] d1 = new int[weight1.length];
        int[] d2 = new int[weight2.length];
        Arrays.fill(d1, 10000);
        Arrays.fill(d2, 10000);
        d1[src] = 0;
        d2[src] = 0;
        Queue<Integer> q = new ArrayDeque<>(weight1.length);
        for (int i = 0; i < weight1.length; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int curNode = -1;
            for (Integer node : q) {
                if (min > d1[node] * d2[node]) {
                    min = d1[node] * d2[node];
                    curNode = node;
                }
            }
            q.remove(curNode);
            for (int i = 0; i < weight1.length; i++) {
                if (weight1[curNode].charAt(i) != '.') {
                    int e1 = weight1[curNode].charAt(i) - '0';
                    int e2 = weight2[curNode].charAt(i) - '0';
                    int newDist = (d1[curNode] + e1) * (d2[curNode] + e2);
                    if (newDist < d1[i] * d2[i]) {
                        d1[i] = (d1[curNode] + e1);
                        d2[i] = (d2[curNode] + e2);
                    }
                }
            }
        }
        return d1[1] * d2[1];
    }
}
