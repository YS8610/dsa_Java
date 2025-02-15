public class lc2017 {
  private static long gridGame(int[][] grid) {
    int l = grid[0].length;
    long[] prefix0 = new long[l];
    long[] prefix1 = new long[l];
    prefix0[0] = grid[0][0];
    prefix1[0] = grid[1][0];
    for (int i=1;i<l;i++){
      prefix0[i] = prefix0[i-1]+ grid[0][i];
      prefix1[i] = prefix1[i-1] + grid[1][i];
    }
    long ans = Long.MAX_VALUE;
    long tmp;
    for (int i=0;i<l;i++){
      if (i ==0){
        ans = prefix0[l-1] - prefix0[0];
        continue;
      }
      if (i == l-1){
        ans = Math.min(ans, prefix1[l-2]);
        continue;
      }
      tmp = Math.max(prefix1[i-1], prefix0[l-1] - prefix0[i]);
      ans = Math.min(ans, tmp);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {{3,3,1},{8,5,2}};
    System.out.println(gridGame(grid));
  }
}
