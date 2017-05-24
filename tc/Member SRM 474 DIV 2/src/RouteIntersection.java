import java.util.*;

public class RouteIntersection {

  public String isValid(int N, int[] coords, String moves) {
    Set<Integer> s = new TreeSet<>();
    for (int i = 0; i < coords.length; i++) {
      s.add(coords[i]);
    }
    Integer[] map = new Integer[s.size()];
    s.toArray(map);
    List<Integer> ints = new ArrayList<>(s.size());
    Collections.fill(ints, 0);
    for (int i = 0; i < moves.length(); i++) {
      ints.get(map[i]);
    }
    return null;
  }
}
