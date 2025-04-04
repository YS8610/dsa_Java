import java.util.Arrays;

public class lc947 {
  static public int removeStones(int[][] stones) {
    int l = stones.length;
    int[] par = new int[l];
    Arrays.fill(par, -1);
    for (int i = 0; i < l; i++) {
      for (int j = i + 1; j < l; j++) {
        if (stones[i][0] != stones[j][0] && stones[i][1] != stones[j][1])
          continue;
        union(par, i, j);
      }
    }
    pathcommpression(par);
    int ans = 0;
    for (int p : par) {
      if (p >= -1)
        continue;
      ans += -(p + 1);
    }
    return ans;
  }

  private static void pathcommpression(int[] par) {
    int l = par.length;
    for (int i = 0; i < l; i++) {
      if (par[i] < 0)
        continue;
      par[i] = getPar(par, i);
    }
  }

  private static void union(int[] par, int s1, int s2) {
    int p1 = getPar(par, s1);
    int p2 = getPar(par, s2);
    if (p1 >= 0 && p1 == p2)
      return;
    if (p1 <= p2) {
      par[p1] += par[p2];
      par[p2] = p1;
      par[s2] = p1;
      return;
    }
    par[p2] += par[p1];
    par[p1] = p2;
    par[s1] = p2;
  }

  private static int getPar(int[] par, int node) {
    if (par[node] < 0)
      return node;
    return getPar(par, par[node]);
  }

  public static void main(String[] args) {
    int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
    System.out.println(removeStones(stones));
  }
}
