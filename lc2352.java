import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2352 {
  private static int equalPairs(int[][] grid){
    Map<List<Integer>,Integer> map = new HashMap<>();
    int n = grid[0].length;
    int[][] cols = new int[n][n];
    for (int i=0; i<n;i++){
      List<Integer> row = new ArrayList<>(n);
      for(int j=0; j<n;j++){
        row.add(grid[i][j]);
        cols[i][j] = grid[j][i];
      }
      if (map.containsKey(row)) map.put(row, map.get(row)+1);
      else map.put(row, 1);
    } 
    int ans = 0;
    for (int[] a : cols){
      List<Integer> colList = new ArrayList<>( Arrays.stream(a).boxed().toList() );
      if (map.containsKey(colList)) ans += map.get(colList);
    }

    return ans;
  }

  public static void main(String[] args) {
    
  }
}
