public class DerangementsDiv2 {

    private static final int MOD = (int) 1e9 + 7;

    public int count(int n, int m) {
        long ans = 1;
        int sign = -1;
        ans = fact(n + m) % MOD;
        for (int i = 1; i <= m; i++) {
            long temp = ncr(m, i) * fact(m + n - i);
            temp = temp % MOD;
            ans = ans + MOD + sign * temp;
            ans = ans % MOD;
            sign *= -1;
        }
        return (int) ans;
    }

    private long ncr(long n, long k) {
        if (n == k || k < 1) {
            return 1;
        }
        long num = fact(n);
        long den = (fact(k) * fact(n - k)) % MOD;
        den = pow(den, MOD - 2);
        return (num * den) % MOD;
    }

    private long pow(long den, long i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1)
            return den;
        long res = 1;
        den %= MOD;
        res = pow(den, i / 2);
        res = (res * res) % MOD;
        if (i % 2 == 1) {
            res = (res * den) % MOD;
        }
        return res;
    }

    private long fact(long i) {
        if (i < 2)
            return 1;
        long res = 1;
        for (int j = 1; j <= i; j++) {
            res = (res * j) % MOD;
        }
        return res;
    }
}


