import java.util.Arrays;

public class SortingSubsets {

    public int getMinimalSize(int[] a) {
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        int cnt = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != a[i])
                cnt++;
        }
        return cnt;
    }
}
