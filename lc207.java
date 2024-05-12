import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc207 {

  private static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int n = prerequisites.length;
    Set<Integer> completed = new HashSet<>();
    for (int i = 0; i < n; i++) {
      int needed = prerequisites[i][0];
      int course = prerequisites[i][1];
      if (map.containsKey(course)) map.get(course).add(needed); else map.put(
        course,
        new HashSet<>(Arrays.asList(needed))
      );
    }
    for (int i = 0; i < numCourses; i++) {
      if (!map.containsKey(i)) map.put(i, new HashSet<>());
    }
    for (int i = 0; i < numCourses; i++) {
      boolean result = dfs(i, map, completed, new HashSet<>());
      if (!result) return false;
    }
    return true;
  }

  private static boolean dfs(
    int course,
    Map<Integer, Set<Integer>> map,
    Set<Integer> completed,
    Set<Integer> visited
  ) {
    if (map.get(course).isEmpty()) return true;
    if (completed.contains(course)) return true;
    if (visited.contains(course)) return false;
    Set<Integer> courseneeded = map.get(course);
    visited.add(course);
    for (int i : courseneeded) {
      boolean result = dfs(i, map, completed, visited);
      if (!result) return false;
    }
    completed.add(course);
    return true;
  }

  public static void main(String[] args) {
    int numCourses = 2;
    int[][] prerequisites = { { 1, 0 } };

    System.out.println(canFinish(numCourses, prerequisites));
  }
}
