import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc3531 {
  static public int countCoveredBuildings(int n, int[][] buildings) {
    Map<Integer, int[]> xmap = new HashMap<>();
    Map<Integer, int[]> ymap = new HashMap<>();
    int[] tmp;
    int ans = 0;
    for (int[] b : buildings) {
      if (xmap.containsKey(b[0])) {
        tmp = xmap.get(b[0]);
        tmp[0] = Math.min(tmp[0], b[1]);
        tmp[1] = Math.max(tmp[1], b[1]);
      } else
        xmap.put(b[0], new int[] { b[1], b[1] });
      if (ymap.containsKey(b[1])) {
        tmp = ymap.get(b[1]);
        tmp[0] = Math.min(tmp[0], b[0]);
        tmp[1] = Math.max(tmp[1], b[0]);
      } else
        ymap.put(b[1], new int[] { b[0], b[0] });
    }
    for (int[] b : buildings) {
      // check for x
      tmp = xmap.getOrDefault(b[0], new int[] { -1, -1 });
      if (tmp[0] == tmp[1] || tmp[0] >= b[1] || tmp[1] <= b[1])
        continue;
      tmp = ymap.getOrDefault(b[1], new int[] { -1, -1 });
      if (tmp[0] == tmp[1] || tmp[0] >= b[0] || tmp[1] <= b[0])
        continue;
      ans++;
    }
    return ans;
  }

  public int countCoveredBuildingsArray(int n, int[][] buildings) {
    if (buildings.length < 4)
      return 0;
    int[][] xmap = new int[n + 1][2];
    int[][] ymap = new int[n + 1][2];
    int[] tmp;
    for (int[] x : xmap)
      Arrays.fill(x, -1);
    for (int[] x : ymap)
      Arrays.fill(x, -1);
    int ans = 0;
    for (int[] b : buildings) {
      if (xmap[b[0]][0] != -1) {
        xmap[b[0]][0] = Math.min(xmap[b[0]][0], b[1]);
        xmap[b[0]][1] = Math.max(xmap[b[0]][1], b[1]);
      } else {
        xmap[b[0]][0] = b[1];
        xmap[b[0]][1] = b[1];
      }
      if (ymap[b[1]][0] != -1) {
        ymap[b[1]][0] = Math.min(ymap[b[1]][0], b[0]);
        ymap[b[1]][1] = Math.max(ymap[b[1]][1], b[0]);
      } else {
        ymap[b[1]][0] = b[0];
        ymap[b[1]][1] = b[0];
      }
    }
    for (int[] b : buildings) {
      // check for x
      tmp = xmap[b[0]];
      if (tmp[0] == tmp[1] || tmp[0] >= b[1] || tmp[1] <= b[1])
        continue;
      tmp = ymap[b[1]];
      if (tmp[0] == tmp[1] || tmp[0] >= b[0] || tmp[1] <= b[0])
        continue;
      ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] buildings = { { 1, 2 }, { 2, 2 }, { 3, 2 }, { 2, 1 }, { 2, 3 } };
    System.out.println(countCoveredBuildings(n, buildings));
  }
}
