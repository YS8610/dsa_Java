import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc3143 {
  public int maxPointsInsideSquare(int[][] points, String s) {
    int l = s.length();
    if (l == 1) return 1;
    Set<Character> set1 = new HashSet<>();
    for (int i = 0; i < l; i++) set1.add(s.charAt(i));
    if (set1.size() == s.length()) return l;
    Integer[][] tmp = new Integer[l][3];
    for (int i = 0; i < l; i++) {
      tmp[i][0] = points[i][0];
      tmp[i][1] = points[i][1];
      tmp[i][2] = (int) s.charAt(i);
    }
    Arrays.sort(
      tmp,
      (m1, m2) -> {
        return Integer.compare(
          Math.max(Math.abs(m1[0]), Math.abs(m1[1])),
          Math.max(Math.abs(m2[0]), Math.abs(m2[1]))
        );
      }
    );
    System.out.println(Arrays.deepToString(tmp));
    int pos = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < l; i++) {
      if (set.contains(tmp[i][2])) {
        pos = i;
        break;
      }
      set.add(tmp[i][2]);
    }
    int ans = 0;
    pos = Math.max(Math.abs(tmp[pos][0]), Math.abs(tmp[pos][1]));
    for (int i = 0; i < l; i++) {
      if (Math.max(Math.abs(tmp[i][0]), Math.abs(tmp[i][1])) >= pos) break;
      ans++;
    }
    return ans;
  }
}
