import java.util.Arrays;

public class LexmaxReplace {

    public String get(String s, String t) {
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();
        Arrays.sort(ct);
        for (int i = 0, j = ct.length - 1; j >= 0 && i < cs.length; i++) {
            if (ct[j] > cs[i]) {
                cs[i] = ct[j];
                j--;
            }
        }
        return new String(cs);
    }
}
