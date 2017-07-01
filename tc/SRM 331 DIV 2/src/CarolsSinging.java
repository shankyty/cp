import java.util.HashSet;
import java.util.Set;

public class CarolsSinging {

    int min;

    public int choose(String[] lyrics) {
        min = -1;
        for (int i = 0; i <= (1 << lyrics[0].length()) - 1; i++) {
            Set<Integer> s = decode(i, lyrics[0].length());
            boolean[] sung = new boolean[lyrics.length];
            for (Integer col : s) {
                for (int j = 0; j < lyrics.length; j++) {
                    sung[j] |= 'Y' == lyrics[j].charAt(col);
                }
            }
            boolean res = true;
            for (boolean aSung : sung) {
                res &= aSung;
            }
            if (res) {
                if (min == -1)
                    min = s.size();
                else
                    min = Math.min(min, s.size());
            }
        }
        return min;
    }

    Set<Integer> decode(int d, int l) {
        String s = Integer.toBinaryString(d);
        Set<Integer> columns = new HashSet<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if ('1' == s.charAt(i)) {
                columns.add(s.length() - 1 - i);
            }
        }
        return columns;
    }
}
