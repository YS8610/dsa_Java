import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc593 {

  private static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    Set<List<Integer>> set = new HashSet<>();
    set.add(List.of(p1[0], p1[1]));
    set.add(List.of(p2[0], p2[1]));
    set.add(List.of(p3[0], p3[1]));
    set.add(List.of(p4[0], p4[1]));
    if (set.size() != 4) return false;

    double d12 = Point2D.distance(p1[0], p1[1], p2[0], p2[1]);
    double d13 = Point2D.distance(p1[0], p1[1], p3[0], p3[1]);
    double d14 = Point2D.distance(p1[0], p1[1], p4[0], p4[1]);
    Map<Double, Integer> map = new HashMap<>();
    double[] dist = new double[] { d12, d13, d14 };
    for (double i : dist) {
      if (map.containsKey(i)) map.put(i, map.get(i) + 1); else map.put(i, 1);
    }
    if (map.size() != 2) return false;
    double max = d12;
    int pos = 0;
    for (int i = 0; i < 3; i++) {
      if (max < dist[i]) {
        max = dist[i];
        // position opposite p0
        pos = i;
      }
    }
    //p2 is opposite p1
    if (pos == 0) {
      if (
        Point2D.distance(p2[0], p2[1], p3[0], p3[1]) !=
        Point2D.distance(p2[0], p2[1], p4[0], p4[1])
      ) return false;
      return helper(p1, p3, p2);
    }
    //p3 is opposite p1
    else if (pos == 1) {
      if (
        Point2D.distance(p3[0], p3[1], p2[0], p2[1]) !=
        Point2D.distance(p3[0], p3[1], p4[0], p4[1])
        ) return false;
        return helper(p1, p2, p3);
      }
      // p4 is opposite p1
      else {
        if (
          Point2D.distance(p4[0], p4[1], p2[0], p2[1]) !=
          Point2D.distance(p4[0], p4[1], p3[0], p3[1])
          ) return false;
          return helper(p1, p2, p4);
        }
    // if ( Math.pow(side, 2)*2-Math.pow(hypo, 2)==0d) return true;
  }

  private static boolean helper(int[]fixed,int[]shorter,int[]longer){
    int aSquare = (fixed[0]-shorter[0])*(fixed[0]-shorter[0]) + (fixed[1]-shorter[1])*(fixed[1]-shorter[1]);
    int cSquare = (fixed[0]-longer[0])*(fixed[0]-longer[0]) + (fixed[1]-longer[1])*(fixed[1]-longer[1]);
    if (aSquare*2==cSquare) return true;
    return false;
  }

  public static void main(String[] args) {
    int[] p1 = { 0, 0 }, p2 = { 1, 1 }, p3 = { 1, 0 }, p4 = { 0, 1 };
    System.out.println(validSquare(p1, p2, p3, p4));
  }
}
