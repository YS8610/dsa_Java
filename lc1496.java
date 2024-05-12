import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc1496 {
  private static boolean isPathCrossing(String path) {
    List<Integer> currentPos = List.of(0, 0);
    Set<List<Integer>> visited = new HashSet<>();
    visited.add(currentPos);
    for (int i=0,n=path.length();i<n;i++){
      if (path.charAt(i)=='N') currentPos = List.of(currentPos.get(0)+1,currentPos.get(1));
      if (path.charAt(i)=='S') currentPos = List.of(currentPos.get(0)-1,currentPos.get(1));
      if (path.charAt(i)=='W') currentPos = List.of(currentPos.get(0),currentPos.get(1)-1);
      if (path.charAt(i)=='E') currentPos = List.of(currentPos.get(0),currentPos.get(1)+1);
      if (visited.contains(currentPos)) return true;
      visited.add(currentPos);
    }
    return false;
  }

  public static void main(String[] args) {
    String path = "NESWW";
    System.out.println( isPathCrossing(path) );
  }
}
