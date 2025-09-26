public class lc3025 {
  static public int numberOfPairs(int[][] points) {
    int l = points.length;
    int ans = 0;
    // lower right corner {{3,1},{1,3},{1,1}};
    for (int i = 0; i < l; i++) {
      // upper left corner
      out: for (int j = 0; j < l; j++) {
        if (i == j)
          continue;
        if (points[i][1] > points[j][1])
          continue;
        if (points[i][0] < points[j][0])
          continue;
        // x1y1 = points[j][0] points[j][1]
        // x2y2 = points[i][0] points[i][1]
        for (int[] p : points) {
          if (p[0] == points[i][0] && p[1] == points[i][1])
            continue;
          if (p[0] == points[j][0] && p[1] == points[j][1])
            continue;
          if (
            p[0] >= points[j][0] &&
            p[0] <= points[i][0] &&
            p[1] <= points[j][1] &&
            p[1] >= points[i][1]
          )
            continue out;
        }
        ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args){
    int[][] points = {{3,1},{1,3},{1,1}};
    System.out.println(numberOfPairs(points));
  }
}
