import java.util.PriorityQueue;

public class lc767 {

  private static String reorganizeString(String s) {
    int[] map = new int[26];
    int l = s.length();
    char[] ans = new char[l];
    for (int i = 0; i < l; i++) map[s.charAt(i) - 'a']++;
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> {
      if (m2[1] == m1[1]) return Integer.compare(m1[0], m2[0]);
      return Integer.compare(m2[1], m1[1]);
    });
    for (int i = 0; i < 26; i++) if (map[i] > 0) pq.add(
      new int[] { i, map[i] }
    );
    int[] tmp = pq.poll();
    for (int i = 0; i < l; i += 2) {
      if (tmp[1] == 0) tmp = pq.poll();
      ans[i] = (char) (tmp[0] + 'a');
      tmp[1]--;
    }
    for (int i = 1; i < l; i += 2) {
      if (tmp[1] == 0) tmp = pq.poll();
      ans[i] = (char) (tmp[0] + 'a');
      tmp[1]--;
    }
    for (int i = 1; i < l; i++) if (ans[i] == ans[i - 1]) return "";
    return new String(ans);
  }

  public static void main(String[] args) {
    String s = "todrnphcamnomskfrhe";
    System.out.println(reorganizeString(s));
  }
}
