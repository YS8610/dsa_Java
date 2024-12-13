public class lc2924 {

  public int findChampion(int n, int[][] edges) {
    if (edges.length == 0 && n == 1) return 0;
    if (edges.length == 0 && n >= 2) return -1;
    boolean[] parent = new boolean[n];
    boolean[] child = new boolean[n];
    for (int[] e : edges) {
      parent[e[0]] = true;
      child[e[1]] = true;
    }
    int ans = -1;
    for (int i = 0; i < n; i++) {
      if (!parent[i] && !child[i]) return -1;
      if (!parent[i]) continue;
      if (parent[i] && !child[i] && ans != -1) return -1;
      if (parent[i] && !child[i] && ans == -1) ans = i;
    }
    return ans;
  }
}
