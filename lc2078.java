import java.util.Arrays;

public class lc2078 {
  public int maxDistance(int[] colors) {
    int l = colors.length;
    int[] map = new int[101];
    boolean[] visited = new boolean[101];
    Arrays.fill(map, -1);
    int ans = 0;
    for (int i = 0; i < l; i++)
      map[colors[i]] = i;
    // System.out.println(Arrays.toString(map));
    for (int i = 0; i < l; i++) {
      if (visited[colors[i]])
        continue;
      for (int j = 0; j < 101; j++) {
        if (map[j] == -1 || colors[i] == j)
          continue;
        ans = Math.max(ans, map[j] - i);
      }
      visited[colors[i]] = true;
    }
    return ans;
  }
}
