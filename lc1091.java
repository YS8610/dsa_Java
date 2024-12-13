import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc1091 {
  private static int shortestPathBinaryMatrix(int[][] grid) {
    int ans =1;
    int lc = grid.length;
    int lr = grid[0].length;
    if (lc ==1 && lr == 1 && grid[0][0] == 0) return 1;
    if (lc ==1 && lr == 1 && grid[0][0] == 1) return -1;
    if (grid[lc-1][lr-1] == 1) return -1; 
    Queue<List<Integer>> q = new LinkedList<>();
    q.add(List.of(0,0));
    List<Integer> tmp;
    int r, c;
    while (!q.isEmpty()){
      for (int i=0, n=q.size(); i <n;i++){
        tmp = q.poll();
        r = tmp.get(0);
        c = tmp.get(1);
        if (r <0 || c<0 || r >= lr || c>=lc) continue;
        if (grid[tmp.get(0)][tmp.get(1)] == 1) continue;
        if (grid[tmp.get(0)][tmp.get(1)] == 2) continue;
        if (r==lc-1 && c == lr-1) return ans;
        grid[tmp.get(0)][tmp.get(1)] = 2;
        q.add(List.of(r+1, c));
        q.add(List.of(r-1, c));
        q.add(List.of(r, c+1));
        q.add(List.of(r, c-1));
        q.add(List.of(r+1, c+1));
        q.add(List.of(r-1, c-1));
        q.add(List.of(r+1, c-1));
        q.add(List.of(r-1, c+1));
      }
      ans++;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
    System.out.println(shortestPathBinaryMatrix(grid));
  }
}
