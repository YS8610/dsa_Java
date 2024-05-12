import java.util.Arrays;

public class lc1637 {
  private static int maxWidthOfVerticalArea(int[][] points) {
    Arrays.sort(points, (m1, m2) -> { 
      if (m1[0]==m2[0]) return Integer.compare(m1[1], m2[1]);
      else return Integer.compare(m1[0], m2[0]);
    });
    System.out.println( Arrays.deepToString(points));
    int max=0;
    for (int i =0, n=points.length;i<n-1;i++){
      max = Math.max(max, points[i+1][0]-points[i][0]);
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] points = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
    System.out.println( maxWidthOfVerticalArea(points) );
  }
}
