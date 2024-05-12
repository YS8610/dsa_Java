import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class lc841 {

  private static void dfs(
    List<List<Integer>> rooms,
    int r,
    Set<Integer> visited
  ) {
    if (rooms.get(r).isEmpty()) {
      visited.add(r);
      return;
    }
    if (visited.contains(r)) return;
    visited.add(r);
    for (int room : rooms.get(r)) dfs(rooms, room, visited);
  }

  private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visited = new HashSet<>();
    dfs(rooms, 0, visited);
    return visited.size() == rooms.size();
  }

  public static void main(String[] args) {
    int[][] room = {{1},{2},{3},{}};
    List<List<Integer>> rooms = new ArrayList<>();
    for(int[] i:room) rooms.add(Arrays.stream(i).boxed().collect(Collectors.toList()));
    System.out.println(canVisitAllRooms(rooms));
  }
}
