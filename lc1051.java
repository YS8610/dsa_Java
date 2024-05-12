import java.util.Arrays;

public class lc1051 {
  private static int heightChecker(int[] heights) {
    int n = heights.length;
    int[] temp = Arrays.copyOf(heights, n);
    Arrays.sort(heights);
    int ans=0;
    for (int i=0; i<n;i++){
      if (temp[i]!=heights[i]) ans++;
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] heights = {1,1,4,2,1,3};
    System.out.println( heightChecker(heights));
  }
}
