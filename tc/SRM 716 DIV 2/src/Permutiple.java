import java.util.Arrays;

public class Permutiple {

    public String isPossible(int x) {
        int mx = x;
        char[] xs = Integer.toString(x).toCharArray();
        Arrays.sort(xs);
        String mxs = Integer.toString(mx);
        int i = 2;
        while (i < 10) {
            mx = i * x;
            char[] mxsc = Integer.toString(mx).toCharArray();
            if (mxs.length() == xs.length) {
                Arrays.sort(mxsc);
                if (Arrays.equals(mxsc, xs)) {
                    return "Possible";
                }
            }
            i++;
        }
        return "Impossible";
    }
}
