public class TrafficCongestionDivTwo {

  public long theMinCars(int treeHeight) {
    long res = 1;
    for (int i = 2; i <= treeHeight; i++) {
      if (i % 2 == 0)
        res = 2 * res + 1;
      else
        res = 2 * res - 1;
    }
    return res;
  }
}