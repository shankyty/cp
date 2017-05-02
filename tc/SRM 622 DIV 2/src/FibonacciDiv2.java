public class FibonacciDiv2 {

  public int find(int N) {
    int f = 0;
    int s = 1;
    while (N < f || s < N) {
      s = s + f;
      f = s - f;
    }
    return Math.min(N - f, s - N);
  }
}