import java.util.HashSet;
import java.util.Set;

public class lc575 {
  static private int distributeCandies(int[] candyType) {
    Set<Integer> set = new HashSet<>();
    for (int c:candyType) set.add(c);
    int l = candyType.length;
    return Math.min(l/2, set.size());
  }
  public static void main(String[] args) {
    int[] candyType = {1000,1000,2,1,2,5,3,1};
    System.out.println(distributeCandies(candyType));
  }
}
