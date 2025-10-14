public class lc812 {
  public double largestTriangleArea(int[][] points) {
    int l = points.length;
    double ans = 0;
    for (int i = 0, n = l - 2; i < n; i++)
      for (int j = i + 1, m = l - 1; j < m; j++)
        for (int k = j + 1; k < l; k++)
          ans = Math.max(ans, area(points[i], points[j], points[k]));
    return ans;
  }

  public double area(int[] a, int[] b, int[] c) {
    return 0.5d * Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1]));
  }
}
