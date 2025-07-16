import java.util.Arrays;
import java.util.PriorityQueue;

public class lc3170 {
  public String clearStars(String s) {
    int l = s.length();
    boolean[] include = new boolean[l];
    Arrays.fill(include, true);
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (m1, m2) -> {
          if (m1[0] == m2[0])
            return Integer.compare(m2[1], m1[1]);
          return Integer.compare(m1[0], m2[0]);
        });
    int[] tmp;
    for (int i = 0; i < l; i++) {
      if (s.charAt(i) == '*') {
        tmp = pq.poll();
        include[tmp[1]] = false;
      } else
        pq.add(new int[] { s.charAt(i), i });
    }
    int ansl = 0;
    for (int i = 0; i < l; i++) {
      if (s.charAt(i) == '*' || !include[i])
        continue;
      ansl++;
    }
    char[] ans = new char[ansl];
    for (int i = 0, j = 0; i < l; i++) {
      if (s.charAt(i) == '*' || !include[i])
        continue;
      ans[j++] = s.charAt(i);
    }
    return String.valueOf(ans);
  }
}
