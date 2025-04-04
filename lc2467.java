import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc2467 {
  private static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int[] e : edges){
      if (adj.containsKey(e[0]))
        adj.get(e[0]).add(e[1]);
      else{
        adj.put(e[0], new HashSet<>());
        adj.get(e[0]).add(e[1]);
      }
      if (adj.containsKey(e[1]))
      adj.get(e[1]).add(e[0]);
      else{
        adj.put(e[1], new HashSet<>());
        adj.get(e[1]).add(e[0]);
      }
    }
    int l = edges.length;
    boolean[] visited = new boolean[l+1];
    int[] turns = new int[l+1];
    Arrays.fill(turns, -1);
    dfsb(adj, bob, turns, visited, 0);
    Arrays.fill(visited, false);
    boolean[] leave = new boolean[l+1];
    for (int i=0, n=l+1; i<n; i++)
      if (adj.get(i).size()==1 && i != 0) 
        leave[i] = true;
    return dfsa(adj, leave, 0, turns, visited, amount, 0);
  }

  private static boolean dfsb(Map<Integer, Set<Integer>> adj, int bob, int[] turns, boolean[] visited, int lvl){
    if (visited[bob]) return false;
    if (bob == 0) {
      turns[bob] = lvl;
      return true;
    }
    visited[bob] = true;
    boolean ans = false;
    for (int node : adj.get(bob)){
      ans = dfsb(adj, node, turns, visited, lvl+1);
      if (!ans) continue;
      turns[bob] = lvl;
      return true;
    }
    return false;
  }

  private static int dfsa(Map<Integer, Set<Integer>> adj, boolean[] leave, int alice, int[] turns, boolean[] visited, int[] amt, int lvl){
    visited[alice] = true;
    int tmp=0;
    if (turns[alice] == -1 || lvl < turns[alice])
      tmp = amt[alice];
    else if (lvl == turns[alice])
      tmp = amt[alice]/2;
    else
      tmp = 0;
    if (leave[alice])
      return tmp;
    List<Integer> list = new ArrayList<>(1);
    int profit;
    for (int node : adj.get(alice)){
      if (visited[node]) continue;
      profit = dfsa(adj, leave, node, turns, visited, amt, lvl+1)+tmp;
      if (list.isEmpty())
        list.add(profit);
      else
        list.set(0, Math.max(list.get(0), profit));
    }
    return list.get(0);
  }

  public static void main(String[] args) {
    int[][] edges = {{0,1},{1,2},{2,3}};
    int bob = 3;
    int[] amount = {-5644,-6018,1188,-8502};
    System.out.println(mostProfitablePath(edges, bob, amount));
  }
}
