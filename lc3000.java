public class lc3000 {
  public int areaOfMaxDiagonal(int[][] dimensions) {
    int ans = 0;
    int diagonal = 0;
    int tmp;
    for (int[] d : dimensions) {
      tmp = d[0] * d[0] + d[1] * d[1];
      if (Integer.compare(tmp, diagonal) == 0)
        ans = Math.max(ans, d[0] * d[1]);
      else if (Integer.compare(tmp, diagonal) > 0) {
        diagonal = tmp;
        ans = d[0] * d[1];
      }
    }
    return ans;
  }
}
