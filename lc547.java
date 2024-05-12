import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc547 {
  
  private static int findCircleNum(int[][] isConnected){
    Set<Integer> visited = new HashSet<>();
    Deque<Integer> stack = new ArrayDeque<Integer>();
    int ans = 0;
    for (int row=0, x=isConnected.length;row<x;row++){
      if (visited.contains(row)) continue;
      else ans++;
      stack.add(row);
      while (!stack.isEmpty()){
        int rowStack = stack.pop();
        for (int col=0, y=isConnected[0].length;col<y;col++){
          if (isConnected[rowStack][col]==1 && !visited.contains(col) ) {
            stack.add(col);
            visited.add(col);
          }
        }
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
    System.out.println( findCircleNum(isConnected) );
  }
}
