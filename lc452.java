import java.util.Arrays;

public class lc452 {

  private static int findMinArrowShots(int[][] points) {
    int len = points.length;
    int ans = 0;
    int j = 0;
    Arrays.sort(
      points,
      (m1, m2) -> {
        if (m1[1] == m2[1]) return Integer.compare(m1[0], m2[0]);
        return Integer.compare(m1[1], m2[1]);
      }
    );
    for (int i = 0; i < len; i++) {
      j = i;
      while (j < len && points[i][1] >= points[j][0]) j++;
      ans++;
      i = j - 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
    System.out.println(findMinArrowShots(points));
  }
}
