import static java.lang.Math.min;

public class DoubleWeights2 {

    boolean[] visisted = new boolean[21];
    private int res = Integer.MAX_VALUE;
    private String[] weight2;
    private String[] weight1;
    private int w2;
    private int w1;


    public int minimalCost(String[] weight1, String[] weight2) {
        this.weight1 = weight2;
        this.weight2 = weight1;
        bt(0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    void bt(int i) {
        if (i == 1) {
            res = min(res, w1 * w2);
            return;
        }
        int e1,e2;
        for (int j = 0; j < weight1[i].length(); j++) {
            if (!visisted[j] && weight1[i].charAt(j) != '.') {
                visisted[j] = true;
                e1 = weight1[i].charAt(j) - '0';
                e2 = weight2[i].charAt(j) - '0';
                w1 += e1;
                w2 +=  e2;
                bt(j);
                w1 -= e1;
                w2 -= e2;
                visisted[j] = false;
            }
        }
    }
}
