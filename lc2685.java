import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2685 {
  static public int countCompleteComponents(int n, int[][] edges) {
    int[] p = new int[n];
    Arrays.fill(p, -1);
    int first, second;
    int ans = 0;
    for (int[] e : edges) {
      first = getPar(p, e[0]);
      second = getPar(p, e[1]);
      if (first == second)
        continue;
      if (first <= second) {
        p[first] += p[second];
        p[e[1]] = first;
        p[second] = first;
      } else {
        p[second] += p[first];
        p[e[0]] = second;
        p[first] = second;
      }
    }
    for (int i=0; i<n;i++){
      if (p[i] < 0)
        continue;
      p[i] = getPar(p, i);
    }

    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] e : edges){
      if (adj.containsKey(e[0]))
        adj.get(e[0]).add(e[1]);
      else
        adj.put(e[0], new ArrayList<>(Arrays.asList(e[1])));
      if (adj.containsKey(e[1]))
        adj.get(e[1]).add(e[0]);
      else
        adj.put(e[1], new ArrayList<>(Arrays.asList(e[0])));
    }
    Map<Integer, List<Integer>> group = new HashMap<>();
    for (int i=0; i<n;i++){
      if (p[i] < 0)
        group.put(i, new ArrayList<>());
      else{
        if (group.containsKey(p[i]))
          group.get(p[i]).add(i);
        else
          group.put(p[i], new ArrayList<>(Arrays.asList(i)));
      }
    }
    int tmp;
    out:
    for (Map.Entry<Integer, List<Integer>> entry : group.entrySet()){
      if (entry.getValue().size() <= 1)
        ans++;
      else{
        tmp = entry.getValue().size()+1;
        if (entry.getValue().size() != tmp - 1)
          continue;
        for (int child : entry.getValue()){
          if (adj.get(child).size() != tmp-1)
            continue out;
        }
        ans++;
      } 
    }
    return ans;
  }


  private static int getPar(int[] p, int node) {
    if (p[node] < 0)
      return node;
    return getPar(p, p[node]);
  }

  public static void main(String[] args) {
    int n = 9;
    int[][] edges = { { 4,8},{0,4},{5,7},{5,3},{5,6},{5,1},{7,3},{7,6},{7,1},{3,6},{3,1},{6,1} };
    System.out.println(countCompleteComponents(n, edges));
  }
}
