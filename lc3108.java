import java.util.Arrays;
// Disjoint set
public class lc3108 {
  static private int[] minimumCost(int n, int[][] edges, int[][] query) {
    int[] ans = new int[query.length];
    int[] map = new int[n];
    Arrays.fill(map, -1);
    int first, second;
    for (int[] e :edges){
      first = dfs(map, e[0]);
      second = dfs(map, e[1]);
      if (first == second)
        continue;
      if (map[first] <= map[second]){
        map[first] += map[second];
        map[e[1]] = first;
        map[second] = first;
      }
      else{
        map[second] += map[first];
        map[e[0]] = second;
        map[first] = second;
      }
    }
    int[] cost = new int[n];
    Arrays.fill(cost, -1);
    for (int[] e : edges){
      if (cost[e[0]] == -1)
        cost[e[0]] = e[2];
      else
        cost[e[0]] &=e[2];
    }
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    int par;
    for (int[] e : edges){
      par =dfs(map, e[0]); 
      memo[par] = memo[par]==-1?e[2]:(memo[par] & e[2]);
    }
    for (int i =0, l=query.length; i<l;i++){
      first= dfs(map, query[i][0]);
      second= dfs(map, query[i][1]);
      if (first != second)
        ans[i] = -1;
      else
        ans[i] = memo[first];
    }
    return ans;
  }

  private static int dfs(int[] map, int child){
    if (map[child] < 0)
      return child;
    return dfs(map, map[child]);
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = {{1,5,1},{4,3,3},{3,5,3},{1,0,1},{3,0,0}};
    int[][] query = {{0,2},{4,5},{5,1},{0,4},{0,1},{0,4},{4,2},{4,0}};
    System.out.println(Arrays.toString(minimumCost(n, edges, query)));
  }
}
