import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

class lc1462{
  private static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries){
    List<Boolean> ans = new ArrayList<>(queries.length);
    List<Set<Integer>> adj = new ArrayList<>(numCourses);
    for (int i=0;i<numCourses;i++)
      adj.add(new HashSet<>());
    for (int[] p :prerequisites)
      adj.get(p[1]).add(p[0]);
    boolean[] visited = new boolean[numCourses];
    boolean[][] parent = new boolean[numCourses][numCourses];
    for (int i =0; i<numCourses;i++)
      dfs(adj, visited, parent, i);
    for (int[] q: queries)
      ans.add(parent[q[1]][q[0]]);
    return ans;
  }

  private static Set<Integer> dfs(List<Set<Integer>> adj, boolean[] visited, boolean[][] parent, int node){
    if (adj.get(node).isEmpty())
      return new HashSet<Integer>();
    if (visited[node]){
      Set<Integer> tmp = new HashSet<>();
      for (int i=0;i<visited.length;i++)
        if (parent[node][i])
          tmp.add(i);
      return tmp;
    }
    visited[node] = true;
    Set<Integer> ans = new HashSet<>();
    for (int n : adj.get(node)){
      ans.add(n);
      ans.addAll(new HashSet<>(dfs(adj, visited, parent, n)));
    }
    for (int n : ans)
      parent[node][n] = true;
    return ans;
  }

  public static void main(String[] args){
    int numCourses = 28;
    int[][] prerequisites = {{25,8},{25,27},{25,19},{25,9},{25,16},{25,13},{25,24},{25,26},{25,3},{25,14},{0,10},{0,19},{0,20},{0,2},{0,21},{0,11},{0,23},{0,26},{0,1},{0,18},{0,7},{8,10},{8,15},{8,20},{8,21},{8,11},{8,17},{8,6},{8,1},{27,12},{27,15},{27,2},{27,16},{27,11},{27,17},{27,18},{10,4},{10,21},{10,16},{10,26},{10,14},{22,12},{22,4},{22,15},{22,19},{22,20},{22,11},{22,17},{22,24},{22,26},{12,4},{12,9},{12,2},{12,21},{12,11},{12,23},{12,17},{12,13},{12,26},{12,1},{12,7},{4,19},{4,9},{4,21},{4,11},{4,1},{15,21},{15,11},{15,23},{15,13},{15,6},{15,24},{15,3},{15,14},{19,20},{19,9},{19,2},{19,17},{19,5},{19,14},{20,9},{20,21},{20,23},{20,6},{20,24},{20,1},{9,2},{9,11},{9,26},{9,3},{9,14},{2,1},{21,17},{21,13},{21,6},{21,7},{16,11},{16,1},{16,14},{11,23},{11,6},{11,24},{11,3},{11,14},{23,13},{23,5},{23,6},{23,24},{23,26},{23,7},{17,24},{17,7},{13,6},{13,24},{13,3},{5,6},{5,1},{5,7},{6,26},{6,1},{6,18},{6,14},{6,7},{24,1},{24,14},{24,7},{26,1},{3,18},{1,14},{1,7},{18,7}};
    int[][] queries = {{20,26},{6,19},{12,27},{8,27},{27,23},{10,5},{2,19},{24,18},{6,27},{26,27},{25,27},{3,27},{20,27},{22,16},{14,25},{22,2},{23,20},{0,17},{8,16},{27,26},{13,22},{27,12},{17,25},{26,4},{25,10},{13,20},{22,23},{21,22},{26,27},{24,14},{0,13},{7,20},{14,23},{26,14},{13,21},{14,25},{6,27},{9,24},{19,27},{10,5},{12,27},{13,25},{13,24},{10,22},{21,6},{26,27},{25,24},{12,23},{18,26},{7,27},{24,16},{18,16},{18,1},{17,14},{22,6},{18,24},{17,7},{0,20},{21,12},{15,24},{21,4},{22,21},{24,4},{23,26},{12,10},{25,18},{9,22},{3,21},{26,21},{25,9},{18,24},{15,19},{23,24},{27,24},{2,4},{26,11},{11,15},{16,27},{3,20},{26,27},{22,17},{23,27},{11,18},{19,18},{19,24},{9,18},{21,23},{16,10},{24,16},{22,8},{22,16},{24,26},{24,26},{17,15},{7,25},{16,11},{14,4},{22,7},{18,19},{23,11},{21,23},{23,14},{4,0},{21,19},{24,10},{22,17},{25,26},{27,25},{27,22},{16,0},{4,26},{7,17},{4,24},{23,17},{18,24},{26,18},{21,22},{27,26},{10,16},{20,15},{21,12},{13,21},{12,1},{19,21},{22,27},{6,21},{24,27},{27,25},{9,26},{7,17},{3,4},{19,27},{15,17},{14,25},{21,4},{21,24},{27,23},{21,15},{10,7},{15,17},{27,24},{3,18},{10,24},{8,13},{26,23},{1,22},{14,25},{7,15},{25,23},{20,18},{24,21},{2,17},{4,18},{8,13},{12,13},{24,27},{11,22},{7,18},{24,2},{20,11},{19,11},{16,14},{19,2},{13,8},{21,23},{13,9},{12,25},{26,25},{27,11},{12,18},{26,27},{23,19},{27,23},{26,27},{27,26},{22,20},{0,10},{27,25},{11,5},{1,9},{22,27},{4,5},{26,10},{13,10},{20,7},{27,18},{27,21},{13,19},{22,20},{22,23},{18,25},{5,1},{26,24},{19,18},{1,22},{6,9},{8,16},{8,23},{13,17},{20,15},{9,3},{7,14},{20,26},{27,19},{20,24},{27,26},{12,1},{24,5},{13,12},{10,1},{21,23},{20,25},{16,0},{22,26},{6,7},{26,25},{6,2},{23,26},{14,6},{3,14},{9,8},{15,14},{27,26},{7,3},{27,3},{9,1},{25,26},{11,27},{22,11},{8,27},{23,21},{20,10},{8,15},{16,10},{23,13},{24,23},{23,10},{22,25},{12,10}};
    System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));
  }
}
