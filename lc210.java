import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class lc210 {
  private static int dfs(List<Set<Integer>> map, int i, int[] visited, Stack<Integer> s){
    if (visited[i] == 1 || map.get(i).size()==0){
      if (visited[i] != 1) s.add(i);
      visited[i] = 1;
      return i;
    }
    for (int m : map.get(i)){
      if (dfs(map, m, visited, s) == m){
        if (visited[m] != 1) s.add(m);
        visited[m] = 1;
      }
    }
    if (visited[i] != 1) s.add(i);
    visited[i] = 1;
    return i;
  }

  private static int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] visited = new int[numCourses];
    List<Set<Integer>> map = new ArrayList<>(numCourses);
    for (int i=0;i<numCourses;i++) map.add(new HashSet<>());
    for (int[] p:prerequisites) map.get(p[1]).add(p[0]);
    Stack<Integer> stack = new Stack<>();
    for (int i =0; i<numCourses;i++){
      dfs(map, i, visited, stack);
    }
    if (stack.size()<numCourses) return new int[0];
    int[] ans = new int[numCourses];
    for (int i = 0; !stack.isEmpty();i++){
      ans[i] = stack.pop();
    }
    return ans;
  }

  public static void main(String[] args) {
    int numCourses = 4;
    int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
    System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
  }
}
