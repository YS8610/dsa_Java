import java.util.Arrays;

public class lc757 {
  public int intersectionSizeTwo(int[][] intervals) {
    Arrays.sort(intervals, (m1, m2) -> {
      if (m1[1] == m2[1])
        return Integer.compare(m2[0], m1[0]);
      return Integer.compare(m1[1], m2[1]);
    });
    int p1 = -1, p2 = -1;
    int ans = 0;
    for (int[] interval : intervals) {
      if (p1 == -1 && p2 == -1) {
        p1 = interval[1] - 1;
        p2 = interval[1];
        ans += 2;
        continue;
      }
      if (p2 >= interval[0]) {
        if (p1 >= interval[0])
          continue;
        p1 = p2;
        p2 = interval[1];
        ans++;
      } else {
        p1 = interval[1] - 1;
        p2 = interval[1];
        ans += 2;
      }
    }
    return ans;
  }
}
