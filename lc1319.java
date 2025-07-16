import java.util.Arrays;

public class lc1319 {
  public static int makeConnected(int n, int[][] connections) {
    int l = connections.length;
    if (n - 1 > l)
      return -1;
    int[] par = new int[n];
    Arrays.fill(par, -1);
    int p1, p2;
    for (int[] c : connections) {
      p1 = getPar(par, c[0]);
      p2 = getPar(par, c[1]);
      if (p1>=0 && p1==p2)
        continue;
      if (par[p1] >= 0 && par[p2] >= 0){
        par[p2] = p1;
        continue;
      }
      // one of them is parent
      if (par[p1] <= par[p2]) {
        par[p1] += par[p2];
        par[p2] = p1;
      } else {
        par[p2] += par[p1];
        par[p1] = p2;
      }
    }
    p1 = 0;
    for (int p : par)
      p1 += p < 0 ? 1 : 0;
    return p1 - 1;
  }

  private static int getPar(int[] par, int a) {
    if (par[a] < 0)
      return a;
    return getPar(par, par[a]);
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
    System.out.println(makeConnected(n, connections));
  }
}
