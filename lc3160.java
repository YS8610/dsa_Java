import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class lc3160{
  
  private static int[] queryResults(int limit, int[][] queries) {
    int l = queries.length;
    int[] ans = new int[l];
    Map<Integer, Integer> colormap = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    int ball, color;
    for (int i =0; i<l;i++){
      ball = queries[i][0];
      // ball change color
      if (colormap.containsKey(ball)){
        // recompute count
        color = colormap.get(ball);
        if (count.get(color) == 1)
          count.remove(color);
        else
          count.put(color, count.get(color)-1);  
      }
      colormap.put(ball, queries[i][1]);
      count.computeIfPresent(queries[i][1], (k,v) -> v+1);
      count.computeIfAbsent(queries[i][1], (k) -> 1);
      // System.out.println(count.toString());
      ans[i] = count.size();
    }
    return ans;
  }

  public static void main(String[] args){
    int limit = 1;
    int[][] queries = new int[][]{{0,1},{0,4},{0,4},{0,1},{1,2}};
    System.out.println(Arrays.toString(queryResults(limit, queries)));
  }
}
