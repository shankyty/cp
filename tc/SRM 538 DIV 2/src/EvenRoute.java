public class EvenRoute {

  public String isItPossible(int[] x, int[] y, int wantedParity) {
    int even = 0;
    for (int i = 0; i < x.length; i++) {
      if ((Math.abs(x[i]) + Math.abs(y[i])) % 2 == 0) {
        even++;
      }
    }
    if ((wantedParity == 1 && even == x.length) || (wantedParity == 0 && even == 0))
      return "CANNOT";
    return "CAN";
  }
}
