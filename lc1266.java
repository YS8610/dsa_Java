public class lc1266 {
  public int minTimeToVisitAllPoints(int[][] points) {
    int l = points.length;
    int ans = 0;
    for (int i = 0, n = l - 1; i < n; i++)
      ans += timeNeeded(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
    return ans;
  }

  private int timeNeeded(int x1, int y1, int x2, int y2) {
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);
    if (dx >= dy)
      return dx;
    return dy;
  }
}
