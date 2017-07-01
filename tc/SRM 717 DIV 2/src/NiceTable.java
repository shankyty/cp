public class NiceTable {

    public String isNice(String[] t) {
        int n = t.length;
        int m = t[0].length();
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < 1 << m; j++) {
                String x = Integer.toBinaryString(i);
                String y = Integer.toBinaryString(j);
                while (x.length() < n) {
                    x = "0" + x;
                }
                while (y.length() < m) {
                    y = "0" + y;
                }

                boolean nice = true;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        nice &= t[k].charAt(l) - '0' == (x.charAt(k) - '0' ^ y.charAt(l) - '0');
                    }
                }
                if (nice) {
                    return "Nice";
                }
            }
        }
        return "Not nice";
    }
}
