import java.util.HashSet;
import java.util.Set;

public class lc1791 {

  public int findCenter(int[][] edges) {
    Set<Integer> set = new HashSet<>();
    for (int[] e : edges) {
      for (int i : e) {
        if (set.contains(i)) return i;
        set.add(i);
      }
    }
    return 0;
  }
}
