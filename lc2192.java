import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc2192 {
  private static void dfs(Map<Integer, List<Integer>> map, List<Set<Integer>> subans, int i){
    if (!map.containsKey(i)) return;
    for (int j:map.get(i)){
      subans.get(j).addAll(subans.get(i));
      subans.get(j).add(i);
    }
    for (int j : map.get(i)) dfs(map, subans, j);
  }

  private static List<List<Integer>> getAncestors(int n, int[][] edges) {
    int len = edges.length;
    List<Integer> l = new ArrayList<>();
    int[] child = new int[n];
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Set<Integer>> subans = new ArrayList<>();
    for (int i=0;i<len;i++) {
      child[edges[i][1]]+=1;
      if (map.containsKey(edges[i][0])) map.get(edges[i][0]).add(edges[i][1]);
      else map.put(edges[i][0], new ArrayList<>(List.of(edges[i][1])));
    }
    for (int i = 0;i<n;i++) subans.add(new HashSet<>());
    for (int i=0;i<n;i++){
      if (child[i] > 0) continue;
      dfs(map, subans, i);
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (Set<Integer> s : subans){
      l = new ArrayList<>(s);
      Collections.sort(l);
      ans.add(l);
    }
    return ans;
  }

  static List<Integer> dfs1(Map<Integer,List<Integer>>map, int i, Map<Integer,List<Integer>> memo){
    Set<Integer> ans= new HashSet<>();
    if (!map.containsKey(i)) return new ArrayList<>();
    if (memo.containsKey(i)) return memo.get(i);
    for (int j:map.get(i)){
      ans.addAll(dfs1(map, j, memo));
      ans.add(j);
    }
    memo.put(i,new ArrayList<>(ans));
    return new ArrayList<>(ans);
  }

  private static List<List<Integer>> getAncestors1(int n, int[][] edges) {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Map<Integer,List<Integer>> memo = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    int len = edges.length;
    Arrays.sort(edges, (m1,m2)->{
      if (m1[0] == m2[0]) return Integer.compare(m1[1], m2[1]);
      return Integer.compare(m1[0], m2[0]);
    });
    for (int i=0;i<len;i++){
      if (map.containsKey(edges[i][1])) map.get(edges[i][1]).add(edges[i][0]);
      else map.put(edges[i][1], new ArrayList<>(List.of(edges[i][0])));
    }
    List<Integer> tmp;
    for (int i=0;i<n;i++){
      tmp = dfs1(map,i, memo);
      Collections.sort(tmp);
      ans.add(tmp);
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 8;
    int[][] edgeList = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
    System.out.println(getAncestors(n, edgeList).toString());
    System.out.println(getAncestors1(n, edgeList).toString());
  }
}
